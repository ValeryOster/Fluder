package de.fluder.demo.utils;

public enum Alphabet {
    LAT ("abcdefgijklsnopqrstuvwxyz"),
    RUS ("абвгдеёжзийклмнопрстуфхцчъыьэюя");

    private String lang;

    Alphabet(String alphabet) {
        this.lang = alphabet;
    }

    public String getLang() {
        return lang;
    }
}
