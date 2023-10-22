package by.pvt.musicproject.repository.dao;

import by.pvt.musicproject.entity.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DaoAlbum extends JpaRepository<Album, Long> {

    @Query(value = "select g from Album g order by g.id")
    Page<Album> findAllOrderById(Pageable pageable);

    List<Album> findByName(String name);
}
