package de.fluder.demo.utils;

import de.fluder.demo.entity.GoEmail;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

@Slf4j
public class GoEmailGenerater {

    public static GoEmail emailAddress() {
        String emailDomain = "emailgo.de";
        String generateName = ValueGenerator.getGenerateString(Alphabet.LAT);
        GoEmail email = new GoEmail();
        Connection.Response response = startSission();

        if (response != null) {
            try {
                Connection.Response execute = Jsoup.connect("https://www.emailgo.de/mailbox/create/custom")
                        .data("_token", getToken(response))
                        .data("email", generateName)
                        .data("domain", emailDomain)
                        .cookies(response.cookies())
                        .method(Connection.Method.POST)
                        .ignoreContentType(true)
                        .execute();
                Utils.saveHtmlToDisk(execute.parse());
            } catch (IOException e) {
                e.printStackTrace();

            }

            email.setEmail(generateName + "@" + emailDomain);
            return email;
        } else {
            return null;
        }
    }

    private static String getToken(Connection.Response execute) {
        Document document = null;
        try {
            document = execute.parse();
        } catch (IOException e) {
            log.error("I can not parse --> " + e.getMessage());
        }
        Element element = document
                .select("input[name='_token']")
                .first();
        return element.val();
    }

    private static Connection.Response startSission() {
        try {
            Connection.Response execute = Jsoup.connect("https://www.emailgo.de/")
                    .execute();
            return execute;
        } catch (IOException e) {
            e.printStackTrace();
            log.error("I have problem with http request --> " + e.getMessage());
        }
        return null;
    }

    public static void getAllMessages(GoEmail goEmail) {
        String url = "https://www.emailgo.de/mailbox/" + goEmail.getEmail();
        Connection.Response response = startSission();
        Connection.Response referer = null;

        if (response != null) {
            try {
                referer = Jsoup.connect(url)
                        .header("referer", url)
                        .cookies(response.cookies())
                        .method(Connection.Method.GET)
                        .ignoreContentType(true)
                        .execute();
                Document parse = referer.parse();
                Utils.saveHtmlToDisk(parse);
                System.out.println(parse);
            } catch (IOException e) {
                log.error("I can not get emails --> " + e.getMessage());
            }
        }
    }
}

