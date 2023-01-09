package soni.sandeep.dao;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class BeanManager {

    @Autowired
    private JdbcStore jdbcStore;

    @Bean
    public DataSource masterEntityManager () throws SQLException {

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setUsername(jdbcStore.getMasterUserName());
        hikariConfig.setPassword(jdbcStore.getMasterPassword());
        hikariConfig.setJdbcUrl(jdbcStore.getMasterUrl());
        hikariConfig.setDriverClassName(jdbcStore.getMasterDriver());
        return new HikariDataSource(hikariConfig);
    }


    @Bean
    public DataSource slaveEntityManager () throws SQLException {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setUsername(jdbcStore.getMasterUserName());
        hikariConfig.setPassword(jdbcStore.getMasterPassword());
        hikariConfig.setJdbcUrl(jdbcStore.getSlaveUrl());
        hikariConfig.setDriverClassName(jdbcStore.getMasterDriver());
       return new HikariDataSource(hikariConfig);
    }



    @Primary
    @Bean(name = "entityManagerFactory")
    public  EntityManagerFactory entityManagerFactory() throws SQLException {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(slaveEntityManager());
        emf.setPackagesToScan("soni.sandeep");
        emf.setPersistenceUnitName("default");
        emf.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());// <- giving 'default' as name
        emf.afterPropertiesSet();
        return emf.getObject();
    }
}
