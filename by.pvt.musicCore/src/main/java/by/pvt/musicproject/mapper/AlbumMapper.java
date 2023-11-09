package by.pvt.musicproject.mapper;

import by.pvt.musicproject.dto.AlbumsReq;
import by.pvt.musicproject.dto.AlbumsRes;
import by.pvt.musicproject.dto.PerformersReq;
import by.pvt.musicproject.entity.Album;
import by.pvt.musicproject.entity.Performer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlbumMapper {
    AlbumsRes toResponse(Album album);
    Album toEntity(AlbumsReq albumsReq);
}
