package by.pvt.musicproject.repository;

import by.pvt.musicproject.configuration.HibernateConfig;
import by.pvt.musicproject.entity.MyPlayList;
import by.pvt.musicproject.entity.TrackList;
import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.repository.dao.DaoMyPlayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class MyPlayListRepository implements DaoMyPlayList {
    private final SessionFactory sessionFactory;

    public MyPlayListRepository() {
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }

    @Override
    public Long add(MyPlayList myPlayList) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(myPlayList);
        session.getTransaction().commit();
        session.close();
        return myPlayList.getId();
    }

    @Override
    public MyPlayList findPlayListById(Long id) {
        Session session = sessionFactory.openSession();
        MyPlayList myPlayList = session.get(MyPlayList.class, id);
        return myPlayList;
    }

    @Override
    public void deletePlayList(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(findPlayListById(id));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<MyPlayList> getAllPlayList() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("Select s from MyPlayList s");
        return (List<MyPlayList>) query.getResultList();
    }
//заменяет плейлист
    public void updatePlayList(MyPlayList myPlayList) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(myPlayList);
        session.getTransaction().commit();
        session.close();
    }
    //добавляет трек в плейлист
    public void addTrackToPlaylist(Long trackid, Long playlistid){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        MyPlayList myPlayList=session.get(MyPlayList.class,playlistid);
        TrackList trackList=session.get(TrackList.class,trackid);
        List<TrackList>trackLists=myPlayList.getTrack();
        trackLists.add(trackList);
        session.merge(myPlayList);
        session.getTransaction().commit();
        session.close();
    }

    public  List<TrackList> findTrackByName(String name, Long playlistid){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query= session.createQuery("select e from MyPlayList e where e.track.name=:name and e.id=:playlistid");
        //    select * from music.myplaylist s join music.add_Track a on s.id=a.myplaylist_id where s.id=1 ;
        query.setParameter("name",name);
        query.setParameter("playlistid",playlistid);
        List<TrackList> trackLists =(List<TrackList>) query.getResultList();
        session.close();
        return trackLists;
    }
}
