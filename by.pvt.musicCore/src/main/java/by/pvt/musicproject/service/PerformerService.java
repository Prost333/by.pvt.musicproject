package by.pvt.musicproject.service;

import by.pvt.musicproject.entity.Performer;

import java.util.List;

public interface PerformerService {
    void add(Performer performer);

    Performer findPerformerById(Long id);

    Performer findPerformerByName(String name);

    void deletePerformer(Long id);

    List<Performer> getAllPerformer();
    List<Performer> detachCriteria(String name);
}
