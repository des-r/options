package io.quell;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.DefaultJpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application-${envTarget}.properties")
@EnableTransactionManagement
@ComponentScan("io.quell.entities")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DatabaseConfig {

    @Value("${spring.jpa.properties.hibernate.default_schema}")
    String schema;

    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.username}")
    String userName;

    @Value("${spring.datasource.password}")
    String password;

    @Value("${spring.jpa.hibernate.show.sql}")
    String showSql;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    String ddlAuto;

    @Value("${spring.jpa.hibernate.dialect}")
    String dialect;

    @Value("${envTarget}")
    String envTarget;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        Properties props = new Properties();
        props.put("hibernate.show_sql", showSql);
        props.put("hibernate.ddl-auto", ddlAuto);
        props.put("hibernate.default_schema", schema);
        props.put("hibernate.dialect", dialect);

        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setHibernateProperties(props);
        factoryBean.setPackagesToScan("io.quell.entities");

        return factoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(DataSource dataSource) {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setDataSource(dataSource);
        manager.setJpaDialect(new DefaultJpaDialect());

        return manager;
    }
}
