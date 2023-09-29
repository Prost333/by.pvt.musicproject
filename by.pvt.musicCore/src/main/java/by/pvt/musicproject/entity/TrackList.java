package by.pvt.musicproject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(schema = "music", name = "track_list")
public class TrackList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String track_name;
    private String style;
    private String lenght;
    @ManyToOne
    @JoinColumn(name = "album_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Albums albumId;
    @OneToOne
    @JoinColumn(name = "performers_id")
    private Performers performers;
    private  String file;
    @ManyToMany(mappedBy = "track")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<MyPlayList> myPlayListListId;


}
