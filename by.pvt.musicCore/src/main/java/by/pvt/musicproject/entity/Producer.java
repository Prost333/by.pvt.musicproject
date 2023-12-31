package by.pvt.musicproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@ToString
@Table(schema = "music", name = "producer")
@PrimaryKeyJoinColumn (name = "p_id")
//select*from fitness.employee e join fitness.user u on e.em_id=u.id;
public class Producer extends  User {
    private  String company;
    private  Long salary;

}
