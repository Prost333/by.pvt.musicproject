package by.pvt.musicproject.repository;

import by.pvt.musicproject.configuration.HibernateConfig;
import by.pvt.musicproject.entity.Producer;
import by.pvt.musicproject.entity.Subscription;
import by.pvt.musicproject.repository.dao.DaoSubscription;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
@Repository
public class SubscriptionRepository  {
//    private  SessionFactory sessionFactory;

//    public SubscriptionRepository() {
//        this.sessionFactory = HibernateConfig.getSessionFactory();
//    }

    public void add(Subscription subscription) {
//        Session session = sessionFactory.openSession();
//        session.getTransaction().begin();
//        session.persist(subscription);
//        session.getTransaction().commit();
//        session.close();
    }


    public Subscription findSubscriptionById(Long id) {
//        Session session = sessionFactory.openSession();
//        Subscription subscription = session.get(Subscription.class, id);
//        return subscription;
        return  null;
    }


    public void deleteSubscription(Long id) {
//        Session session=sessionFactory.openSession();
//        session.getTransaction().begin();
//        session.delete(findSubscriptionById(id));
//        session.getTransaction().commit();
//        session.close();

    }


    public List<Subscription> getAllSubscription() {
//        Session session = sessionFactory.openSession();
//        Query query = (Query) session.createQuery("Select s from Subscription s");
//        return (List<Subscription>) query.getResultList();
        return  null;
    }
}
