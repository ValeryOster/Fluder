package de.fluder.demo.parsing;

import de.fluder.demo.utils.ValueGenerator;
import org.jsoup.Connection;
import org.jsoup.Jsoup;


public class LoginGenerator {
    private void getMain() {
        Connection connect = Jsoup.connect("https://azbyka.ru/znakomstva/signup-new")
//                .data("first_name", ValueGenerator.getGenerateNameRu())
//                .data("email", ValueGenerator.getGenerateNameRu())
//                .data("first_name", ValueGenerator.getGenerateNameRu())
//                .data("first_name", ValueGenerator.getGenerateNameRu())
//                .data("first_name", ValueGenerator.getGenerateNameRu())
//                .data("first_name", ValueGenerator.getGenerateNameRu())
                ;
    }
}
