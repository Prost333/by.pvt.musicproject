package by.pvt.musicproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserRequest {
    private Long id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String role;
}
