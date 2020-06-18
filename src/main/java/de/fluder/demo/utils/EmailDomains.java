package de.fluder.demo.utils;

public enum EmailDomains {
    SHARKLASERS_COM ("sharklasers.com"),
    GUERRILLAMAIL_INFO ("guerrillamail.info"),
    GUERRILLAMAIL_BIZ ("guerrillamail.biz"),
    GUERRILLAMAIL_NET ("guerrillamail.net"),
    GUERRILLAMAIL_ORG ("guerrillamail.org"),
    GUERRILLAMAIL_DE ("guerrillamail.de"),
    POKEMAIL_NET ("pokemail.net"),
    GRR_LA ("grr.la");

    private String email;

    EmailDomains(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
