package com.blackneptune;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

/**
 * Created by Admin on 5/8/2017.
 */
@Configuration
@ComponentScan (basePackages = "com.blackneptune")
@EnableTransactionManagement
//@EnableJpaRepositories(basePackages="com.blackneptune",entityManagerFactoryRef = "entityManagerFactory",
//        transactionManagerRef = "transactionManager")
@PropertySource("classpath:application.properties")

public class AppConfig {


    @Autowired
    private Environment env;

    @Autowired
    private DataSource dataSource;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf =
                new LocalContainerEntityManagerFactoryBean();

        emf.setDataSource(dataSource);
        emf.setPackagesToScan("com.blackneptune.dao");
        emf.setPackagesToScan("com.blackneptune.service");
        emf.setPackagesToScan("com.blackneptune.entity");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setDatabase(Database.MYSQL);
        emf.setJpaVendorAdapter(vendorAdapter);

        Properties additionalProperties = new Properties();
//        additionalProperties.put(
//                "hibernate.dialect",
//                env.getProperty("hibernate.dialect"));
        additionalProperties.put(
                "hibernate.format_sql",String.valueOf(true));
//        additionalProperties.put(
//                "hibernate.show_sql",
//                env.getProperty("hibernate.show_sql"));
        emf.setJpaProperties(additionalProperties);
        emf.afterPropertiesSet();//NOTICE HERE!!!
        return emf;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

//
//    @Bean(destroyMethod = "close")
//    public JpaTransactionManager transactionManager() {
//        JpaTransactionManager transactionManager =
//                new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(
//                entityManagerFactory.getObject());
//        return transactionManager;
//    }

//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//        return new PersistenceExceptionTranslationPostProcessor();
//    }

    @Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}