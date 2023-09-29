package by.pvt.musicproject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(schema = "music", name = "performers")
public class Performers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String closenes;
    @OneToMany(mappedBy = "performers", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Albums> albums;
    @OneToOne
    @JoinColumn(name = "track_id")
    private TrackList trackList;


}
