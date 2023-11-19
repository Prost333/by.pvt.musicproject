package by.pvt.musicproject.mapper;

import by.pvt.musicproject.dto.RatingReq;
import by.pvt.musicproject.dto.RatingRes;
import by.pvt.musicproject.entity.Rating;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RatingMapper {
    RatingRes toResponse (Rating rating);
    Rating toEntity(RatingReq ratingReq);
}
