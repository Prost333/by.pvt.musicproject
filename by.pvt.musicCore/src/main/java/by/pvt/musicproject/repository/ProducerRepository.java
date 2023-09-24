package by.pvt.musicproject.repository;

import by.pvt.musicproject.configuration.HibernateConfig;
import by.pvt.musicproject.entity.Producer;
import by.pvt.musicproject.repository.dao.DaoProducer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class ProducerRepository implements DaoProducer {
    private final SessionFactory sessionFactory;

    public ProducerRepository() {
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }
    @Override
    public void add(Producer producer) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(producer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Producer findProducerById(Long id) {
        Session session = sessionFactory.openSession();
        Producer user = session.get(Producer.class, id);
        return user;
    }

    @Override
    public void deleteProducer(Long id) {
        Session session=sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(findProducerById(id));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Producer> getAllProducer() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("Select s from Producer s");
        return (List<Producer>) query.getResultList();
    }
}
