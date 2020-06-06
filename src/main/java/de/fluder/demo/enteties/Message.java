package de.fluder.demo.enteties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Message {
    private String mail_body;
    private String mail_date;
    private String mail_from;
    private String mail_recipient;
    private String mail_subject;

}
