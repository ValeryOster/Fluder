package de.fluder.demo.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @SerializedName("list")
    private List<Message> messages;

}
