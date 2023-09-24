package by.pvt.musicproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "music", name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class User {

}
