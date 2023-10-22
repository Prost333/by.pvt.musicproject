package by.pvt.musicproject.repository;

import by.pvt.musicproject.configuration.HibernateConfig;
import by.pvt.musicproject.entity.Performer;
import by.pvt.musicproject.repository.dao.DaoPerformer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
@Repository
public class PerformerRepository  {
    private  SessionFactory sessionFactory;

//    public PerformerRepository() {
//        this.sessionFactory = HibernateConfig.getSessionFactory();
//    }


    public void add(Performer performer) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(performer);
        session.getTransaction().commit();
        session.close();
    }


    public Performer findPerformerById(Long id) {
        Session session = sessionFactory.openSession();
        Performer performer = session.get(Performer.class, id);
        return performer;
    }
//проверь метод

    public Performer findPerformerByName(String name) {
        Session session = sessionFactory.openSession();
        Performer performer = session.get(Performer.class, name);
        return performer;
    }


    public void deletePerformer(Long id) {
        Session session=sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(findPerformerById(id));
        session.getTransaction().commit();
        session.close();
    }


    public List<Performer> getAllPerformer() {
        Session session = sessionFactory.openSession();
        Query query = (Query) session.createQuery("Select s from Performer s");
        return (List<Performer>) query.getResultList();
    }


    public List<Performer> detachCriteria(String name) {
        return null;
    }

}
