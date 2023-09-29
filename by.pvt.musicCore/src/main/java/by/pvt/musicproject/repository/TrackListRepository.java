package by.pvt.musicproject.repository;

import by.pvt.musicproject.configuration.HibernateConfig;
import by.pvt.musicproject.entity.MyPlayList;
import by.pvt.musicproject.entity.TrackList;
import by.pvt.musicproject.repository.dao.DaoTrackList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class TrackListRepository implements DaoTrackList {
    private final SessionFactory sessionFactory;

    public TrackListRepository() {
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }

    @Override
    public Long add(TrackList trackList) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(trackList);
        session.getTransaction().commit();
        session.close();
        return trackList.getId();
    }

    @Override
    public TrackList findTrackById(Long id) {
        Session session = sessionFactory.openSession();
        TrackList trackList = session.get(TrackList.class, id);
        session.close();
        return trackList;
    }

    @Override
    public void deleteTrackList(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(findTrackById(id));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<TrackList> getAllList() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("Select s from TrackList s");
        return (List<TrackList>) query.getResultList();
    }

    public List<TrackList> findAllByIds(List<Long> ids) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select s from TrackList s where s.id in(:ids)");
        query.setParameter("ids", ids);
        List<TrackList> trackList = (List<TrackList>) query.getResultList();
        session.close();
        return trackList;
    }

    public void updateTrack(TrackList trackList) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(trackList);
        session.getTransaction().commit();
        session.close();
    }

    public List<TrackList> getTrackByStyle(String style) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select s from TrackList s where s.style in (:style)");
        query.setParameter("style", style);
        List<TrackList> trackList = (List<TrackList>) query.getResultList();
        session.close();
        return trackList;
    }

    public List<TrackList> findAllByPerformer(Long performer) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select s from TrackList s where s.performers in (:performer)");
        query.setParameter("performer", performer);
        List<TrackList> trackList = (List<TrackList>) query.getResultList();
        session.close();
        return trackList;
    }

    public List<TrackList> findAllByAlbums(Long album) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select s from TrackList s where s.album in (:album)");
        query.setParameter("album", album);
        List<TrackList> trackList = (List<TrackList>) query.getResultList();
        session.close();
        return trackList;
    }

    public List<TrackList> findByName(String name) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select s from TrackList s where s.name in (:name)");
        query.setParameter("name", name);
        List<TrackList> trackList = (List<TrackList>) query.getResultList();
        session.close();
        return trackList;
    }


}
