package de.fluder.demo.utils;

import lombok.Builder;
import net.bytebuddy.implementation.bind.annotation.Default;

import java.util.GregorianCalendar;
import java.util.Random;

public class ValueGenerator {

    public static String getGenerateString(Alphabet alphabet) {
        return getGenerateString(alphabet, 3);
    }

    public static String getGenerateString(Alphabet alphabet, Integer length){
        String mainString = alphabet.getLang();
        Random r = new Random();
        int min = length + r.nextInt(8);
        String name = "";
        for (int i = 0; i < min; i++) {
            if (i == 0) {
                name = String.valueOf( mainString.charAt(r.nextInt( mainString.length()))).toUpperCase();
            } else {
                name += String.valueOf( mainString.charAt(r.nextInt( mainString.length())));
            }
        }
        return name;
    }

}
