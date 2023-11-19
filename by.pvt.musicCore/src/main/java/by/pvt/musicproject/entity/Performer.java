package by.pvt.musicproject.entity;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(schema = "music", name = "performers")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "performer")
@Cacheable
public class Performer {
    @Id
    @SequenceGenerator(name = "seq_performer", sequenceName = "performer_seq", allocationSize = 1, schema = "music")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_performer")
    private Long id;
    @Column(name = "name",unique = true)
    private String name;
    private String closenes;
    @OneToMany(mappedBy = "performer", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Album> album;
    @OneToMany(mappedBy = "performer", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Track> track;


}
