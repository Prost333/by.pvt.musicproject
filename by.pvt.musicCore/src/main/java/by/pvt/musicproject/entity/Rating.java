package by.pvt.musicproject.entity;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(schema = "music", name = "rating")
@Inheritance(strategy = InheritanceType.JOINED)
public class Rating {
    @Id
    @SequenceGenerator(name = "seq_rating", sequenceName = "rating_seq", allocationSize = 1, schema = "music")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_rating")
    @Column(name = "id")
    private Long id;
    @Column(name = "mark")
    private Long mark;
    @Column(name = "track_id")
    private Long trackId;
    @Column(name = "userid")
    private Long userid;


}
