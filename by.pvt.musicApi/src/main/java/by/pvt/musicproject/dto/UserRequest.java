package by.pvt.musicproject.dto;

import lombok.Data;


@Data

public class UserRequest {
    private Long id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String role;

}
