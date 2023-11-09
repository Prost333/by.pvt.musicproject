package by.pvt.musicproject.mapper;

import by.pvt.musicproject.dto.SubscriptionReq;
import by.pvt.musicproject.dto.SubscriptionRes;
import by.pvt.musicproject.entity.Subscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {
    SubscriptionRes toResponse (Subscription subscription);
    Subscription toEntity(SubscriptionReq subscriptionReq);
}
