package by.pvt.musicproject.repository;

import by.pvt.musicproject.configuration.HibernateConfig;
import by.pvt.musicproject.entity.Performer;
import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.repository.dao.DaoPerformer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PerformerRepository implements DaoPerformer {
    private final SessionFactory sessionFactory;

    public PerformerRepository() {
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }

    @Override
    public void add(Performer performer) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(performer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Performer findPerformerById(Long id) {
        Session session = sessionFactory.openSession();
        Performer performer = session.get(Performer.class, id);
        return performer;
    }
//проверь метод
    @Override
    public Performer findPerformerByName(String name) {
        Session session = sessionFactory.openSession();
        Performer performer = session.get(Performer.class, name);
        return performer;
    }

    @Override
    public void deletePerformer(Long id) {
        Session session=sessionFactory.openSession();
        session.getTransaction().begin();
        session.delete(findPerformerById(id));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Performer> getAllPerformer() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("Select s from Performer s");
        return (List<Performer>) query.getResultList();
    }

    public List<Performer> detachCriteria(String name) {
        DetachedCriteria employees = DetachedCriteria.forClass(Performer.class);
        employees.add(Restrictions.eq("name", name));
        EntityManager entityManager = sessionFactory.createEntityManager();
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = employees.getExecutableCriteria(session);
        return (List<Performer>) criteria.list();
    }
}
