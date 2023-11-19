package by.pvt.musicproject.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProducerRequest {
    private Long id;
    private  String company;
    private  Long salary;
    @NotBlank(message = "поле name должно не быть пустым")
    private String name;
    @NotBlank(message = "поле surname должно не быть пустым")
    private String surname;
    @NotBlank(message = "поле login должно не быть пустым")
    private String login;
    @NotBlank(message = "поле password должно не быть пустым")
    private String password;
    private String role;
}
