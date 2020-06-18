package de.fluder.demo.utils;

import com.google.gson.Gson;
import de.fluder.demo.entity.Email;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

public class EmailGenerator {

    public static Email emailAddress() {
        String generateName = ValueGenerator.getGenerateString(Alphabet.LAT);
        String body = null;
        try {
            body = Jsoup.connect("http://guerrillamail.com/ajax.php?f=set_email_user")
                    .data("email_user", generateName)
                    .data("lang", "ru")
                    .data("site", "guerrillamail.com").method(Connection.Method.POST).ignoreContentType(true).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(body);
        Gson gson = new Gson();
        Email email = gson.fromJson(body, Email.class);
        email.setEmailGenerateName(generateName);
        return email;
    }

    public static Email getEmails(Email email) {
        String body = null;
        try {
            body = Jsoup
                    .connect("https://www.guerrillamail.com/ajax.php?f=check_email&seq=0&site=guerrillamail.com&in="
                            + email.getEmailGenerateName() + "&_=1591368644973")
                    .method(Connection.Method.GET)
                    .ignoreContentType(true)
                    .execute()
                    .body();

        } catch (IOException e) {
            e.printStackTrace();
        }
        email = new Gson().fromJson(body, Email.class);
        return email;
    }
}

