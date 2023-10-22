package by.pvt.musicproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class TrackRes {
    private Long id;
    private String track_name;
    private String style;
    private String lenght;
    private  String file;
}
