package by.pvt.musicproject.dto;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class AmountReq {
    @PositiveOrZero
    private Long amount;
    @PositiveOrZero
    private Long amountByProducer;
    private  Long idLastAdmin;

}
