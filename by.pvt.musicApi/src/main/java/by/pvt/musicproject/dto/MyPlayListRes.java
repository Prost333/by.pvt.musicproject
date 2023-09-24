package by.pvt.musicproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;
@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class MyPlayListRes {
    private  Long id;
    private  Long userId;
    private List<Long> trackId;

}
