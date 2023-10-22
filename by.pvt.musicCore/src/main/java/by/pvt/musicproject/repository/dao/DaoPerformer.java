package by.pvt.musicproject.repository.dao;

import by.pvt.musicproject.dto.PerformersReq;
import by.pvt.musicproject.entity.Album;
import by.pvt.musicproject.entity.Performer;
import by.pvt.musicproject.entity.Rating;
import by.pvt.musicproject.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DaoPerformer  extends JpaRepository<Performer,Long> {

    @Query(value = "select g from Performer g order by g.id")
    Page<Performer> findAllOrderById(Pageable pageable);

    List<Performer> findByName(String name);
}
