package by.pvt.musicproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class TrackListReq {
    private Long id;
    private String track_name;
    private String style;
    private String lenght;
    private Long id_albom;
    private Long id_performers;
    private  String file;
}
