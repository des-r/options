package io.quell;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Component
@Log
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AnotherBean {
    final String myString = "Hello from AnotherBean";

    EntityManager entityManager;

    @Autowired
    public AnotherBean(EntityManager entityManager) {
        log.info("------------- Inside AnotherBean ---------------");
        this.entityManager = entityManager;
    }

    public void consoleWriteDatabaseCurrentDate() {
        Query currentDate = entityManager.createNativeQuery("select current_date from dual");
        System.out.println("\n\nDatabase query result: "+currentDate.getResultList());
    }
}
