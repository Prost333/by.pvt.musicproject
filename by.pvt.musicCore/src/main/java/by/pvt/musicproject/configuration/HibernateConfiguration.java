package by.pvt.musicproject.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jca.support.LocalConnectionFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("by.pvt.musicproject")
@EnableTransactionManagement
@EnableJpaRepositories("by.pvt.musicproject")
@PropertySource("application.properties")
public class HibernateConfiguration {
    @Value("${server.url}")
    private  String url;
    @Value("${server.driver}")
    private  String driver;
    @Value("${server.login}")
    private  String login;
    @Value("${server.password}")
    private  String pass;
    @Value("${hibernate.dialect}")
    private  String dialect;
    @Value("${hibernate.show_sql}")
    private  boolean showSql;
    @Value("${hibernate.format_sql}")
    private boolean formatSql;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hdm2ddl;
    @Value("${hibernate.packagesToScan}")
    private String packagesToScan;



//    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }

    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(driver);
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(login);
        hikariConfig.setPassword(pass);
        final HikariDataSource ds = new HikariDataSource(hikariConfig);
        return ds;
    }
    @Bean
    public Properties hibernateProperties(){
        Properties properties=new Properties();
        properties.put("hibernate.dialect",dialect);
        properties.put("hibernate.show.sql", showSql);
        properties.put("hibernate.format_sql",formatSql);
        properties.put("hibernate.hbm2ddl.auto",hdm2ddl);
        return properties;
    }
    //    @Bean
//    public SessionFactory sessionFactory(DataSource dataSource,
//                                         Properties hibernateProperties)throws Exception{
//        LocalSessionFactoryBean localSessionFactoryBean=new LocalSessionFactoryBean();
//        localSessionFactoryBean.setDataSource(dataSource);
//        localSessionFactoryBean.setPackagesToScan(packagesToScan);
//        localSessionFactoryBean.setHibernateProperties(hibernateProperties);
//        localSessionFactoryBean.afterPropertiesSet();
//        return localSessionFactoryBean.getObject();
//    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean= new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan(packagesToScan);
        entityManagerFactoryBean.setJpaProperties(hibernateProperties());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return  entityManagerFactoryBean;
    }
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return jpaTransactionManager;
    }


}
