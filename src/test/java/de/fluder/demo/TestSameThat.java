package de.fluder.demo;

import de.fluder.demo.utils.Alphabet;
import de.fluder.demo.utils.ValueGenerator;
import org.hibernate.annotations.LazyToOneOption;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestSameThat {

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

        generateNames.stream().forEach(System.out::println);
    }


    @Test
    public void getEmail() throws IOException {
        String generateName = ValueGenerator.getGenerateNameRu(Alphabet.LAT.getLang());
        String body = Jsoup.connect("http://guerrillamail.com/ajax.php?f=set_email_user")
                .data("email_user", generateName)
                .data("lang", "ru")
                .data("site", "guerrillamail.com").method(Connection.Method.POST).execute().body();
        System.out.println(body);
    }

    @Test
    public void testAlphabet() throws IOException {
        System.out.println(Alphabet.RUS.getLang());
    }
}

