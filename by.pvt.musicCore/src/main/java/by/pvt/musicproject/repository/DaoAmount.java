package by.pvt.musicproject.repository;

import by.pvt.musicproject.entity.Amount;
import by.pvt.musicproject.entity.Performer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DaoAmount extends JpaRepository<Amount,Long> {

}
