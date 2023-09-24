package by.pvt.musicproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Embeddable
@NoArgsConstructor
@Table(schema = "music", name = "MyPlayList")
public class MyPlayList {


}
