package by.pvt.musicproject.dto;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SubscriptionReq {
    private Long id;
    private LocalDateTime startData;
    private LocalDateTime endData;
    private Long user_id;
    private Long playlist_id;
    @PositiveOrZero
    private BigDecimal subsPrice;
}
