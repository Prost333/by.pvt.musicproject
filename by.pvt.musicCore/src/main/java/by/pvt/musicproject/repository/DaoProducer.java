package by.pvt.musicproject.repository;

import by.pvt.musicproject.entity.Performer;
import by.pvt.musicproject.entity.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DaoProducer extends JpaRepository<Producer,Long> {

}
