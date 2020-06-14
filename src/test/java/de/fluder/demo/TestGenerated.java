package de.fluder.demo;

import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

public class TestGenerated {

    @Test
    public void getGenerateBirthday() {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1965, 2000);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        System.out.println(gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH));
    }

    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
