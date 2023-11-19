package by.pvt.musicproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Getter
@Setter
@ToString
@Table(schema = "music", name = "amount")
public class Amount {

    @Id
    @SequenceGenerator(name = "seq_user", sequenceName = "user_seq", allocationSize = 1, schema = "music")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    @Column(name = "id")
    private Long id;
    @Column(name = "amount")
    private Long amount;
    @Column(name = "amountByProducer")
    private Long amountByProducer;
    @Column(name = "idLastAdmin")
    private  Long idLastAdmin;
}
