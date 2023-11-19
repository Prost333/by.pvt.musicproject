package by.pvt.musicproject.music;

import by.pvt.musicproject.dto.TrackReq;
import by.pvt.musicproject.dto.TrackRes;
import by.pvt.musicproject.entity.Album;
import by.pvt.musicproject.entity.Performer;
import by.pvt.musicproject.entity.Track;
import by.pvt.musicproject.mapper.TrackMapper;
import by.pvt.musicproject.service.AlbumService;
import by.pvt.musicproject.service.PerformerService;
import by.pvt.musicproject.service.TrackListService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdapterSend {
    private  final TrackListService trackListService;
    private  final AlbumService albumService;
    private  final PerformerService performerService;
    private  final TrackMapper trackMapper;
    private  final RecordPlayer recordPlayer;

    @SneakyThrows
    public TrackRes addTrack(TrackReq trackReq){
        Track track= trackMapper.toEntity(trackReq);
        track.setLenght(String.valueOf(recordPlayer.getDuration(track.getFile())));
        track.setAlbums(albumService.findEntityByName(trackReq.getAlbum()).get(0));
        track.setPerformer(performerService.findPerformerEntityByName(trackReq.getPerformer1()).get(0));
       return trackListService.add(track);
    }

}
