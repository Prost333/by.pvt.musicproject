package by.pvt.musicproject.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Data
@Getter
@Setter
public class UserResponse {
    private Long id;

    private String name;
    private String surname;
    private String login;
    private String password;
    private String role;


}
