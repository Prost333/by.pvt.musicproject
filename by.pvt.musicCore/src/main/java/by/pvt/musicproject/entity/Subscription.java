package by.pvt.musicproject.entity;


import lombok.Data;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(schema = "music", name = "subscription")
public class Subscription {
    @Id
    @SequenceGenerator(name = "seq_subscription", sequenceName = "subscription_seq", allocationSize = 1, schema = "music")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_subscription")
    private Long id;
    private LocalDateTime startData;
    private LocalDateTime endData;
    private Long user_id;
    private BigDecimal subsPrice;
    @OneToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;


}
