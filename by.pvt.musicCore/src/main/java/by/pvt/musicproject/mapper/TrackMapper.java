package by.pvt.musicproject.mapper;

import by.pvt.musicproject.dto.TrackReq;
import by.pvt.musicproject.dto.TrackRes;
import by.pvt.musicproject.entity.Performer;
import by.pvt.musicproject.entity.Track;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TrackMapper {
    @Mapping(target = "performer1",source ="performer.name")
    @Mapping(target = "album",source ="albums.name")
    TrackRes toResponse(Track track);

    Track toEntity(TrackReq trackReq);

}
