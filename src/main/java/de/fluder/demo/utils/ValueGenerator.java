package de.fluder.demo.utils;

import java.util.Random;

public class ValueGenerator {

    public static String getGenerateNameRu(String alphabet) {
        Random r = new Random();
        int min = 3 + r.nextInt(8);
        String name = "";
        for (int i = 0; i < min; i++) {
            if (i == 0) {
                name = String.valueOf( alphabet.charAt(r.nextInt( alphabet.length()))).toUpperCase();
            } else {
                name += String.valueOf( alphabet.charAt(r.nextInt( alphabet.length())));
            }
        }
        return name;
    }
}
