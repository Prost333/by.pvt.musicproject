package by.pvt.musicproject.entity;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
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
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name= "track")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Track> track;


}
