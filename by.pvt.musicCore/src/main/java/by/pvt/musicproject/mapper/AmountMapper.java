package by.pvt.musicproject.mapper;

import by.pvt.musicproject.dto.AmountReq;
import by.pvt.musicproject.dto.AmountRes;
import by.pvt.musicproject.entity.Amount;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AmountMapper {
    AmountRes toResponse(Amount amount);

    Amount toEntity(AmountReq amountReq);
}
