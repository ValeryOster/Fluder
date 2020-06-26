package de.fluder.demo.utils;

import de.fluder.demo.entity.GoEmail;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoEmailGeneraterTest {

    @Test
    void emailAddress() {
        GoEmail goEmail = GoEmailGenerater.emailAddress();
        System.out.println(goEmail.getEmail());
    }

    @Test
    void getAllMessages() {
        GoEmail goEmail = new GoEmail();
        goEmail.setEmail("Islwkst@emailgo.de");
        GoEmailGenerater.getAllMessages(goEmail);
    }
}
