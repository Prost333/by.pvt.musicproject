package by.pvt.musicproject.dto;



import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Data
public class TrackReq {
    private Long id;
    @NotBlank(message = "поле name должно не быть пустым")
    private String name;

    private String style;
    @NotBlank(message = "поле lenght должно не быть пустым")
    private String lenght;

    private String album;
    private String performer1;
    @NotBlank(message = "поле file должно не быть пустым")
    private  String file;
}
