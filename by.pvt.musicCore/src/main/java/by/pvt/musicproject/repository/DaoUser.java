package by.pvt.musicproject.repository;

import by.pvt.musicproject.entity.Rating;
import by.pvt.musicproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DaoUser extends JpaRepository<User,Long> {


}

