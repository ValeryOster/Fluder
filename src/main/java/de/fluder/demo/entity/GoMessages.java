package de.fluder.demo.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter@Setter
@Entity
public class GoMessages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String senderEmail;
    private String subject;
    private String text;


    @OneToOne
    @MapsId
    private GoEmail email;

}


