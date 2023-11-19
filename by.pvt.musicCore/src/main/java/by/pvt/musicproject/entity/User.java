package by.pvt.musicproject.entity;

import lombok.*;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(schema = "music", name = "user", uniqueConstraints={@UniqueConstraint(columnNames={"login"})})
@Inheritance(strategy = InheritanceType.JOINED)

public class User implements UserDetails {
    @Id
    @SequenceGenerator(name = "seq_user", sequenceName = "user_seq", allocationSize = 1, schema = "music")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "login", unique = true)
    private String login;
    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.REMOVE)
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

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role));
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String getUsername() {return login;}
    public  String getPassword(){return  password;}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
