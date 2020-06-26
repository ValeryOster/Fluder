package de.fluder.demo.parsing;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class LoginGeneratorTest {

    @Test
    public void testGenarator() throws IOException {
        LoginGenerator loginGenerator = new LoginGenerator();
        loginGenerator.getMain();
    }


}
