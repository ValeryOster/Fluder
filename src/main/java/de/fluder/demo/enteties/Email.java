package de.fluder.demo.enteties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Email {
    private String alias;
    private String email_addr;
    private String email_timestamp;
    private String sid_token;
    private String site;
    private String emailGenerateName;

}
