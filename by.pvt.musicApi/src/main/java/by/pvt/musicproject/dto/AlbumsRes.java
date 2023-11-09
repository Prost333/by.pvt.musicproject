package by.pvt.musicproject.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
@Data
public class AlbumsRes {
    private Long id;
    private String name;
    private String style;
    private LocalDate Relese;
}
