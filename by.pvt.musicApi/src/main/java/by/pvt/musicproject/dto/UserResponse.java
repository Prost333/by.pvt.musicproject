package by.pvt.musicproject.dto;

import lombok.*;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserResponse {
    private Long id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String role;


}
