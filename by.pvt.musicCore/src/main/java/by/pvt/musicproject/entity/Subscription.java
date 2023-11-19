package by.pvt.musicproject.entity;


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
    @Column(name="start_data")
    private LocalDateTime startData;
    @Column(name="end_data")
    private LocalDateTime endData;
    @Column(name="user_id")
    private Long userId;
    private BigDecimal subsPrice;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;


}
