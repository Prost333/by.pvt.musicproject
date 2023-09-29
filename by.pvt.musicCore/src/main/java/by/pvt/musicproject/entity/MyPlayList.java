package by.pvt.musicproject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Embeddable
@NoArgsConstructor
@Table(schema = "music", name = "MyPlayList")
public class MyPlayList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @ManyToMany
    @JoinTable(schema = "music",
    name= "add_track",
    joinColumns = {@JoinColumn(name="myplaylist_id")},
    inverseJoinColumns = {@JoinColumn(name="track_id")})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<TrackList> track;
//    select * from music.myplaylist s join music.add_Track a on s.id=a.myplaylist_id where s.id=1 ;

}
