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
public class Album {
    @Id
    @SequenceGenerator(name = "seq_album", sequenceName = "album_seq", allocationSize = 1, schema = "music")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_album")
    private Long id;
    private String name;
    private String style;
    private LocalDate Relese;
    @ManyToOne
    @JoinColumn(name = "performers_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Performer performer;
    @OneToMany
//    @JoinColumn(name= "track_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Track> track;


}
