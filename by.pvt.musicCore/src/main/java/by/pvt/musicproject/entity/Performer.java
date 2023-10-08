package by.pvt.musicproject.entity;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(schema = "music", name = "performers")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "performer")
public class Performer {
    @Id
    @SequenceGenerator(name = "seq_performer", sequenceName = "performer_seq", allocationSize = 1, schema = "music")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_performer")
    private Long id;
    private String name;
    private String closenes;
    @OneToMany(mappedBy = "performer", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Album> album;
    @OneToMany(mappedBy = "performer", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Track> track;


}
