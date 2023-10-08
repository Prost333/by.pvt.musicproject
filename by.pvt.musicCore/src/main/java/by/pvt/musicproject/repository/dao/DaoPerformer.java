package by.pvt.musicproject.repository.dao;

import by.pvt.musicproject.dto.PerformersReq;
import by.pvt.musicproject.entity.Performer;
import by.pvt.musicproject.entity.User;

import java.util.List;

public interface DaoPerformer {
    void add(Performer performer);

    Performer findPerformerById(Long id);

    Performer findPerformerByName(String name);

    void deletePerformer(Long id);

    List<Performer> getAllPerformer();

    List<Performer> detachCriteria(String name);
}
