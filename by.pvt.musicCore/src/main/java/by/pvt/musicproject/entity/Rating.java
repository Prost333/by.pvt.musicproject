package by.pvt.musicproject.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(schema = "music", name = "rating")
public class Rating {
    @Id
    @SequenceGenerator(name = "seq_rating", sequenceName = "rating_seq", allocationSize = 1, schema = "music")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_rating")
    private Long id;
    private Long mark;
    @ManyToMany(mappedBy = "mark")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Track track;


}
