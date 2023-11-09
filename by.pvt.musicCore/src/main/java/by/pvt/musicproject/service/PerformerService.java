package by.pvt.musicproject.service;

import by.pvt.musicproject.dto.PerformersReq;
import by.pvt.musicproject.dto.PerformersRes;
import by.pvt.musicproject.entity.Album;
import by.pvt.musicproject.entity.Performer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PerformerService {
    PerformersRes add(PerformersReq performersReq);

    PerformersRes findPerformerById(Long id);

    List<PerformersRes> findPerformerByName(String name);

    List<Performer> findPerformerEntityByName(String name);

    void deletePerformer(Long id);

    List<PerformersRes> getAllPerformer();

    Performer addAlbumToPerformer(Long performerId, Album album);

    Page<Performer> getAllPerformerPage(int page, int size);
}
