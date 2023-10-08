package by.pvt.musicproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data

public class UserResponse {
    private Long id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String role;


}
