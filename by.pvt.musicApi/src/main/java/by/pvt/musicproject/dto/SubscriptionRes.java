package by.pvt.musicproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class SubscriptionRes {
    private Long id;
    private LocalDateTime startData;
    private LocalDateTime endData;
    private Long user_id;
    private Long playlist_id;
    private BigDecimal subsPrice;
}
