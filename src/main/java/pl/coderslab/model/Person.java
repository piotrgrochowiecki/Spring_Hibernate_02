package pl.coderslab.model;

import lombok.Data;

@Data
public class Person {

    private String login;
    private String password;
    private String email;
}