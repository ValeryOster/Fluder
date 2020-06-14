package de.fluder.demo.parsing;

import de.fluder.demo.entity.Account;
import de.fluder.demo.entity.Email;
import de.fluder.demo.utils.AccountGenerater;
import de.fluder.demo.utils.EmailGenerator;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.util.Random;


public class LoginGenerator {
    private void getMain() {
        Email email = EmailGenerator.emailAddress();
        Account newAccount = AccountGenerater.getNewAccount(email.getEmail_addr());
        Connection connect = Jsoup.connect("https://azbyka.ru/znakomstva/signup-new")
                .data("first_name", newAccount.getFirstName())
                .data("email", newAccount.getEmail())
                .data("password",newAccount.getPassword())
                .data("country_id",Integer.toString(new Random().nextInt(21)+7))
                .data("birthdate[day]",newAccount.getBirthDay())
                .data("birthdate[month]",newAccount.getBirthMonth())
                .data("birthdate[year]",newAccount.getBirthYear())
                .data("gender",Integer.toString(newAccount.getGender()))
                .data("terms","1")
                .data("goal","734");
    }
}
