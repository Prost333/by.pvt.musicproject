package by.pvt.musicproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;

@Data
public class AlbumsReq {
    private Long id;
    @NotBlank(message = "поле name должно не быть пустым")

    private String name;
    private String style;
    @NotNull(message = "поле relese должно не быть пустым")
    private LocalDate relese;
}
