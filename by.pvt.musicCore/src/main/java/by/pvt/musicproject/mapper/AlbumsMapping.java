package by.pvt.musicproject.mapper;

import by.pvt.musicproject.dto.AlbumsReq;
import by.pvt.musicproject.dto.AlbumsRes;
import by.pvt.musicproject.entity.Albums;

public class AlbumsMapping {
    public AlbumsRes toResponse(Albums albums){
        AlbumsRes albumsRes=new AlbumsRes();
        albumsRes.setId(albums.getId());
        albumsRes.setName(albums.getName());
        albumsRes.setRelese(albums.getRelese());
        albumsRes.setStyle(albums.getStyle());
        return albumsRes;
    }

    public Albums toAlbumsEntity(AlbumsReq albumsReq){
        Albums albums=new Albums();
        albums.setId(albumsReq.getId());
        albums.setName(albumsReq.getName());
        albums.setRelese(albumsReq.getRelese());
        albums.setStyle(albumsReq.getStyle());
        return albums;
    }
}
