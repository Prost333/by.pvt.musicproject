package by.pvt.musicproject.mapper;

import by.pvt.musicproject.dto.TrackReq;
import by.pvt.musicproject.dto.TrackRes;
import by.pvt.musicproject.entity.Track;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TrackMapper {
    TrackRes toResponse(Track track);
    Track toEntity(TrackReq trackReq);
}
