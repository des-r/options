package io.quell;

import lombok.extern.java.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Log
public class SpringApplication {

    public static void main(String[] args) {
        log.info("******************** Lombok rocks ******************* " + log.getClass());
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        AnotherBean anotherBean = (AnotherBean) ctx.getBean("anotherBean");

        anotherBean.consoleWriteDatabaseCurrentDate();
    }
}
