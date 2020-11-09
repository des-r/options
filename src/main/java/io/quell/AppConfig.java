package io.quell;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
@ComponentScan("io.quell")
public class AppConfig {

    @PersistenceContext
    EntityManager entityManager;

    @Bean
    protected MyBean myBean(AnotherBean anotherBean) {
        return new MyBean(anotherBean);
    }

    @Bean
    protected AnotherBean anotherBean() {
        return new AnotherBean(entityManager);
    }
}
