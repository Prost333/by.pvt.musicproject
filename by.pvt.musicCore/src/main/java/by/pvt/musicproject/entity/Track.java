package by.pvt.musicproject.entity;

import lombok.*;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(schema = "music", name = "track_list")
public class Track {
    @Id
    @SequenceGenerator(name = "seq_track", sequenceName = "track_seq", allocationSize = 1, schema = "music")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_track")
    private Long id;
    private String name;
    private String style;
    private String lenght;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "albums")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Album albums;
    @ManyToOne
    @JoinColumn(name = "performers_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Performer performer;
    private  String file;
    @ManyToMany(mappedBy = "track", fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<User> user;
//    @ManyToMany(mappedBy = "track")
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    private List<Rating> rating;


}
