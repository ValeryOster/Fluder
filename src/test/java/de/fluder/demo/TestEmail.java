package de.fluder.demo;

import com.google.gson.Gson;
import de.fluder.demo.entity.GrrEmail;
import de.fluder.demo.utils.Alphabet;
import de.fluder.demo.utils.ValueGenerator;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestEmail {

    String emailUrl = "https://www.guerrillamail.com/ajax.php?f=check_email&seq=0&site=guerrillamail.com&in=";
    String firstCheck = "https://www.guerrillamail.com/ajax.php?f=get_email_list&offset=0&sid_token=";
    Gson gson = new Gson();
    //@Test
    public void printRussian() throws UnsupportedEncodingException {
        Random r = new Random();
        String rus = "абвгдеёжзийклмнопрстуфхцчъыьэюя";
        List<String> generateNames = new ArrayList<>();
        int min = 3 + r.nextInt(8);
        for (int a = 0; a < 10; a++) {
            String str = "";
            for (int i = 0; i < min; i++) {
                if (i == 0) {
                    str = String.valueOf(rus.charAt(r.nextInt(rus.length()))).toUpperCase();
                } else {

                    str += String.valueOf(rus.charAt(r.nextInt(rus.length())));
                }
            }
            generateNames.add(str);
        }

        generateNames.forEach(System.out::println);
    }

    public GrrEmail testEmailGeneration() throws IOException {
        String generateName = ValueGenerator.getGenerateString(Alphabet.LAT);
        String body = Jsoup.connect("http://guerrillamail.com/ajax.php?f=set_email_user")
                .data("email_user", generateName)
                .data("lang", "ru")
                .data("site", "guerrillamail.com").method(Connection.Method.POST).ignoreContentType(true).execute().body();
        System.out.println(body);
        GrrEmail email = this.gson.fromJson(body, GrrEmail.class);
        System.out.println(email.getEmail_addr());
        email.setEmailGenerateName(generateName);
        return email;
    }


    @Test
    public void testEmailList() throws IOException, InterruptedException {
        GrrEmail email = testEmailGeneration();
        Thread.sleep(3000);
        String url = firstCheck +=email.getSid_token();
        System.out.println(url);
        String jsonFromServer = getJsonFromServer(url);

        email = this.gson.fromJson(jsonFromServer, GrrEmail.class);

        System.out.println(email.getMessages().get(0).getMail_body());

    }

    private String getJsonFromServer(String url) throws IOException {
        String body = Jsoup
                .connect(url)
                .method(Connection.Method.GET)
                .ignoreContentType(true)
                .execute()
                .body();

        System.out.println(body);
        return body;
    }

    //@Test
    public void testAlphabet() throws IOException {
        System.out.println(Alphabet.RUS.getLang());
    }
}

