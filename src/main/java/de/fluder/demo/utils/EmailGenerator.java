package de.fluder.demo.utils;

import com.google.gson.Gson;
import de.fluder.demo.enteties.Email;
import de.fluder.demo.enteties.Message;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmailGenerator {

    public static Email emailAddress() {
        String generateName = ValueGenerator.getGenerateName(Alphabet.LAT.getLang());
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

    public static List<Message> getEmails(Email email) {
        String body = null;
        List<Message> emails = new ArrayList<>();
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

        return emails;
    }
}

