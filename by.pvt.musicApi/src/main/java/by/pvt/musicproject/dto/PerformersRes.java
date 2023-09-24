package by.pvt.musicproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class PerformersRes {
    private Long id;
    private String name;
    private String closenes;
}
