package by.pvt.musicproject.dto;

import lombok.Data;

import java.util.List;

@Data
public class RatingReq {
    private Long id;
    private Long mark;
    private Long trackId;
    private Long userid;

}
