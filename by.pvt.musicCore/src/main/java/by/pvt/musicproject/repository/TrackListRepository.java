package by.pvt.musicproject.repository;

import by.pvt.musicproject.configuration.HibernateConfig;
import by.pvt.musicproject.entity.Performer;
import by.pvt.musicproject.entity.Track;
import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.repository.dao.DaoTrackList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
public class TrackListRepository  {
    private SessionFactory sessionFactory;

    public List<String> getAllFile() {
        Session session = sessionFactory.openSession();
        Query query = (Query) session.createQuery("Select s.file from Track s");
        return (List<String>) query.getResultList();
    }

    public List<Track> findAllByIds(List<Long> ids) {
        Session session = sessionFactory.openSession();
        Query query = (Query) session.createQuery("select s from Track s where s.id in(:ids)");
        query.setParameter("ids", ids);
        List<Track> track = (List<Track>) query.getResultList();
        session.close();
        return track;
    }

    public void updateTrack(Track track) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(track);
        session.getTransaction().commit();
        session.close();
    }

    public List<Track> getTrackByStyle(String style) {
        Session session = sessionFactory.openSession();
        Query query = (Query) session.createQuery("select s from Track s where s.style in (:style)");
        query.setParameter("style", style);
        List<Track> track = (List<Track>) query.getResultList();
        session.close();
        return track;
    }

    public List<Track> findAllByPerformer(Long performer) {
        Session session = sessionFactory.openSession();
        Query query = (Query) session.createQuery("select s from Track s where s.performers in (:performer)");
        query.setParameter("performer", performer);
        List<Track> track = (List<Track>) query.getResultList();
        session.close();
        return track;
    }

    public List<Track> findAllByAlbums(Long album) {
        Session session = sessionFactory.openSession();
        Query query = (Query) session.createQuery("select s from Track s where s.album in (:album)");
        query.setParameter("album", album);
        List<Track> track = (List<Track>) query.getResultList();
        session.close();
        return track;
    }

    public List<Track> findByName(String name) {
        Session session = sessionFactory.openSession();
        Query query = (Query) session.createQuery("select s from Track s where s.name in (:name)");
        query.setParameter("name", name);
        List<Track> track = (List<Track>) query.getResultList();
        session.close();
        return track;
    }
    public List<Track> findAllWithPagination(int size, int page) {
        EntityManager entityManager = (EntityManager) sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Track> criteriaQuery = criteriaBuilder.createQuery(Track.class);
        Root<Track> track = criteriaQuery.from(Track.class);
        criteriaQuery.select(track).orderBy(criteriaBuilder.asc(track.get("id")));

        TypedQuery<Track> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setMaxResults(size);
        typedQuery.setFirstResult(page);

        List<Track> trackList = typedQuery.getResultList();
        return trackList;
    }
    public  List <Track> findTrackByPerformer(Long id){
        EntityManager entityManager = (EntityManager) sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Track>criteriaQuery=criteriaBuilder.createQuery(Track.class);
        Root<Track> trackRoot=criteriaQuery.from(Track.class);
        Join<Track, Performer>performer=trackRoot.join("performer");
        criteriaQuery.where(criteriaBuilder.equal(performer.get("id"), id));
        List<Track>tracks=entityManager.createQuery(criteriaQuery).getResultList();
        return tracks;
    }
    public  List <Track> findUserPlayList(Long id){
        EntityManager entityManager = (EntityManager) sessionFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Track>criteriaQuery=criteriaBuilder.createQuery(Track.class);
        Root<Track> trackRoot=criteriaQuery.from(Track.class);
        Join<Track, User>performer=trackRoot.join("user");
        criteriaQuery.where(criteriaBuilder.equal(performer.get("id"), id));
        List<Track>tracks=entityManager.createQuery(criteriaQuery).getResultList();
        return tracks;
    }




}
