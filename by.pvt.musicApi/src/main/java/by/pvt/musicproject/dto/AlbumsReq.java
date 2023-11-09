package by.pvt.musicproject.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AlbumsReq {
    private Long id;
    @NotBlank(message = "поле name должно не быть пустым")
    private String name;
    private String style;
    @NotBlank(message = "поле relese должно не быть пустым")
    private LocalDate relese;
}
