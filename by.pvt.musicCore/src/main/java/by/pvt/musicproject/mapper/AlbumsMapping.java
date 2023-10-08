package by.pvt.musicproject.mapper;

import by.pvt.musicproject.dto.AlbumsReq;
import by.pvt.musicproject.dto.AlbumsRes;
import by.pvt.musicproject.entity.Album;

public class AlbumsMapping {
    public AlbumsRes toResponse(Album album){
        AlbumsRes albumsRes=new AlbumsRes();
        albumsRes.setId(album.getId());
        albumsRes.setName(album.getName());
        albumsRes.setRelese(album.getRelese());
        albumsRes.setStyle(album.getStyle());
        return albumsRes;
    }

    public Album toAlbumsEntity(AlbumsReq albumsReq){
        Album album =new Album();
        album.setId(albumsReq.getId());
        album.setName(albumsReq.getName());
        album.setRelese(albumsReq.getRelese());
        album.setStyle(albumsReq.getStyle());
        return album;
    }
}
