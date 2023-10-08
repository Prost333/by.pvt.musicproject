package by.pvt.musicproject.mapper;

import by.pvt.musicproject.dto.TrackListReq;
import by.pvt.musicproject.dto.TrackListRes;
import by.pvt.musicproject.entity.Track;

public class TrackListMapping {
    public TrackListRes toResponse(Track track){
        TrackListRes trackListRes=new TrackListRes();
        trackListRes.setTrack_name(track.getTrack_name());
        trackListRes.setStyle(track.getStyle());
        trackListRes.setLenght(track.getLenght());
        trackListRes.setFile(track.getFile());
//        trackListRes.setId_albom(track.getId_albom());
//        trackListRes.setId_performers(track.getId_performers());
        trackListRes.setId(track.getId());
        return trackListRes;
    }

    public Track toTrackListEntity(TrackListReq trackListReq){
        Track track =new Track();
        track.setFile(track.getFile());
        track.setTrack_name(trackListReq.getTrack_name());
        track.setId(trackListReq.getId());
        track.setLenght(trackListReq.getLenght());
//        track.setId_albom(trackListReq.getId_albom());
//        track.setId_performers(trackListReq.getId_performers());
        track.setStyle(trackListReq.getStyle());
        return track;
    }
}
