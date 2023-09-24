package by.pvt.musicproject.configuration;



import by.pvt.musicproject.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateConfig {
    private  final static StandardServiceRegistryBuilder serviceRegitryBuilder;
    private final static Configuration conf;

    static {
        Properties properties= new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.use_sql_comments", "true");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("hibernate.connection.driver","org.postgresql.Driver");
        properties.setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5432/music");
        properties.setProperty("hibernate.connection.username", "postgres" );
        properties.setProperty("hibernate.connection.password", "sa" );
        properties.setProperty("hibernate.show_sql","true");
        properties.setProperty("hibernate.show_format","true");
        conf=new Configuration();
        conf.setProperties(properties);
        conf.addAnnotatedClass(User.class);
        conf.addAnnotatedClass(Albums.class);
        conf.addAnnotatedClass(MyPlayList.class);
        conf.addAnnotatedClass(Performers.class);
        conf.addAnnotatedClass(Subscription.class);
        conf.addAnnotatedClass(TrackList.class);
        conf.addAnnotatedClass(Producer.class);
        serviceRegitryBuilder = new StandardServiceRegistryBuilder();
        serviceRegitryBuilder.applySettings(properties);
    }
    public static SessionFactory getSessionFactory(){
        SessionFactory sessionFactory=conf.buildSessionFactory(serviceRegitryBuilder.build());
        return sessionFactory;
    }

}
