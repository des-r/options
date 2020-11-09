package io.quell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    @Autowired
    public MyBean(AnotherBean anotherBean) {
//        log.info("+++++++++++++ Creating MyBean, injecting AnotherBean " + anotherBean);
    }
}
