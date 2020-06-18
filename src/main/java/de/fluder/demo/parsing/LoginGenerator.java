package de.fluder.demo.parsing;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import de.fluder.demo.entity.Account;
import de.fluder.demo.entity.Email;
import de.fluder.demo.repositories.TelefonNummerRepo;
import de.fluder.demo.utils.AccountGenerater;
import de.fluder.demo.utils.EmailGenerator;
import de.fluder.demo.utils.Utils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Map;
import java.util.Random;


public class LoginGenerator {
    public static final String singNewUrl = "https://azbyka.ru/znakomstva/signup-new";
    @Autowired
    private TelefonNummerRepo nummerRepo;

    public void getMain() throws IOException {
        Email email = EmailGenerator.emailAddress();
        Account newAccount = AccountGenerater.getNewAccount(email);
        Connection.Response execute = Jsoup.connect(singNewUrl)
                .data("first_name", newAccount.getFirstName())
                .data("email", newAccount.getEmailNick())
                .data("password", newAccount.getPassword())
                .data("country_id", Integer.toString(new Random().nextInt(21) + 7))
                .data("birthdate[day]", newAccount.getBirthDay())
                .data("birthdate[month]", newAccount.getBirthMonth())
                .data("birthdate[year]", newAccount.getBirthYear())
                .data("gender", Integer.toString(newAccount.getGender()))
                .data("terms", "1")
                .data("goal", "734")
                .method(Connection.Method.POST)
                .execute();

//
//        Map<String, String> cookies = execute.cookies();
//
//        cookies.forEach((s, s2) -> System.out.println("Item: " + s + ", Count: " +s2));
//
//        Connection.Response phone =
//                Jsoup.connect(singNewUrl).cookies(cookies).data("phone", "%2B79000001111").method(Connection.Method.POST).execute();
        Utils.saveHtmlToDisk(execute.parse());

    }
}
