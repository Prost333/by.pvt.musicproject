package by.pvt.musicproject.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(schema = "music", name = "albums")
public class Albums {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String style;
    private LocalDate Relese;
    @ManyToOne
    @JoinColumn(name = "performers_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Performers performers;
    @OneToMany
    @JoinColumn(name= "track_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<TrackList> trackList;


}
