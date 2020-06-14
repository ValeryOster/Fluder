package de.fluder.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter@Setter@NoArgsConstructor
public class Account {
    @Id
    private Long id;

    private String firstName;
    private String email;
    private String password;
    private String birthDay;
    private String birthMonth;
    private String birthYear;
    private int gender;
}
