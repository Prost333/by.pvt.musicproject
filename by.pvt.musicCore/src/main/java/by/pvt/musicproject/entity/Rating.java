package by.pvt.musicproject.entity;

import lombok.*;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(schema = "music", name = "rating")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Rating {
    @Id
    @SequenceGenerator(name = "seq_rating", sequenceName = "rating_seq", allocationSize = 1, schema = "music")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_rating")
    private Long id;
    private Long mark;
    @ManyToMany
    @JoinTable(schema = "music",
            name= "rating_list",
            joinColumns = {@JoinColumn(name="rating_id")},
            inverseJoinColumns = {@JoinColumn(name="track_id")})
    private List<Track> track;

    private Long userid;


}
