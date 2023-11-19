package by.pvt.musicproject.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RatingRes {
    private Long id;
    @Min(0)
    @Max(5)
    private Long mark;
    @NotNull
    private Long trackId;
    @NotNull
    private Long userid;

}
