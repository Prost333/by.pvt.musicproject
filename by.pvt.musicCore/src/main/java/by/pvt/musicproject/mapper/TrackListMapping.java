package by.pvt.musicproject.mapper;

import by.pvt.musicproject.dto.TrackListReq;
import by.pvt.musicproject.dto.TrackListRes;
import by.pvt.musicproject.entity.TrackList;

public class TrackListMapping {
    public TrackListRes toResponse(TrackList trackList){
        TrackListRes trackListRes=new TrackListRes();
        trackListRes.setTrack_name(trackList.getTrack_name());
        trackListRes.setStyle(trackList.getStyle());
        trackListRes.setLenght(trackList.getLenght());
        trackListRes.setFile(trackList.getFile());
//        trackListRes.setId_albom(trackList.getId_albom());
//        trackListRes.setId_performers(trackList.getId_performers());
        trackListRes.setId(trackList.getId());
        return trackListRes;
    }

    public  TrackList toTrackListEntity(TrackListReq trackListReq){
        TrackList trackList=new TrackList();
        trackList.setFile(trackList.getFile());
        trackList.setTrack_name(trackListReq.getTrack_name());
        trackList.setId(trackListReq.getId());
        trackList.setLenght(trackListReq.getLenght());
//        trackList.setId_albom(trackListReq.getId_albom());
//        trackList.setId_performers(trackListReq.getId_performers());
        trackList.setStyle(trackListReq.getStyle());
        return  trackList;
    }
}
