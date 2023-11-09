package by.pvt.musicproject.entity;

import lombok.*;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(schema = "music", name = "user")
@Inheritance(strategy = InheritanceType.JOINED)

public class User {
    @Id
    @SequenceGenerator(name = "seq_user", sequenceName = "user_seq", allocationSize = 1, schema = "music")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscription", insertable = true,updatable = true)
    private Subscription subscription;
    @Column(name = "role")
    private String role;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(schema = "music",
            name= "playlist",
            joinColumns = {@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name="track_id")})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Track> track;

}
