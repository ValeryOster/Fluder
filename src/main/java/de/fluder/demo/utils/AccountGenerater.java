package de.fluder.demo.utils;

import de.fluder.demo.entity.Account;

import java.util.GregorianCalendar;
import java.util.Random;

public class AccountGenerater {

    public static Account getNewAccount(String email) {
        GregorianCalendar gc = getGenerateBirthday();
        Account account = new Account();
        account.setBirthDay(Integer.toString(gc.get(gc.DAY_OF_MONTH)));
        account.setBirthMonth(Integer.toString(gc.get(gc.MONTH)));
        account.setBirthYear(Integer.toString(gc.get(gc.YEAR)));
        account.setEmail(email);
        account.setGender(1);
        account.setPassword(ValueGenerator.getGenerateString(Alphabet.LAT, new Random().nextInt(6)+7));
        return account;
    }

    private static GregorianCalendar getGenerateBirthday() {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1965, 2000);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        return gc;
    }

    private static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
