package by.pvt.musicproject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(schema = "music", name = "track_list")
public class Track {
    @Id
    @SequenceGenerator(name = "seq_track", sequenceName = "track_seq", allocationSize = 1, schema = "music")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_track")
    private Long id;
    private String track_name;
    private String style;
    private String lenght;
    @ManyToOne
    @JoinColumn(name = "album_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Album albumId;
    @ManyToOne
    @JoinColumn(name = "performers_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Performer performer;
    private  String file;
    @ManyToMany(mappedBy = "track")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<User> user;


}
