package by.pvt.musicproject.repository;

import by.pvt.musicproject.configuration.HibernateConfig;
import by.pvt.musicproject.entity.Producer;
import by.pvt.musicproject.repository.dao.DaoProducer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
@Repository
public class ProducerRepository  {
    private  SessionFactory sessionFactory;



    public void add(Producer producer) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(producer);
        session.getTransaction().commit();
        session.close();
    }



    public Producer findProducerById(Long id) {
        Session session = sessionFactory.openSession();
        Producer user = session.get(Producer.class, id);
        return user;
    }


    public void deleteProducer(Long id) {
        Session session=sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(findProducerById(id));
        session.getTransaction().commit();
        session.close();
    }


    public List<Producer> getAllProducer() {
        Session session = sessionFactory.openSession();
        Query query = (Query) session.createQuery("Select s from Producer s");
        return (List<Producer>) query.getResultList();
    }
}
