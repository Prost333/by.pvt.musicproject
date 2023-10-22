package by.pvt.musicproject.mapper;

import by.pvt.musicproject.dto.PerformersReq;
import by.pvt.musicproject.dto.PerformersRes;
import by.pvt.musicproject.entity.Performer;
import org.mapstruct.Mapper;

@Mapper
public interface PerformerMapper {
    PerformersRes toResponse(Performer performer);
    Performer toEntity(PerformersReq performersReq);
}
