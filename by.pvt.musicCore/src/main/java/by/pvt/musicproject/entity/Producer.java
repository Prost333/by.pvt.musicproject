package by.pvt.musicproject.entity;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(schema = "music", name = "producer")
@PrimaryKeyJoinColumn (name = "p_id")
//select*from fitness.employee e join fitness.user u on e.em_id=u.id;
public class Producer extends  User {
    private  String company;
    private  Long salary;
    @Column(name = "label",unique = true)
    private  Long label;

}
