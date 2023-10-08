package by.pvt.musicproject.repository;

import by.pvt.musicproject.configuration.HibernateConfig;
import by.pvt.musicproject.entity.Track;
import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.repository.dao.DaoUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.Query;
import java.util.List;

public class UserRepository implements DaoUser {
    private final SessionFactory sessionFactory;

    public UserRepository() {
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }

    @Override
    public void add(User user) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public User findUserById(Long id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        Session session=sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(findUserById(id));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> getAllUser() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("Select s from User s");
        return (List<User>) query.getResultList();
    }
    public void addTrackToPlaylist(Long trackid, Long userId){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user =session.get(User.class,userId);
        Track track =session.get(Track.class,trackid);
        List<Track> tracks =user.getTrack();
        tracks.add(track);
        session.merge(user);
        session.getTransaction().commit();
        session.close();
    }
}
