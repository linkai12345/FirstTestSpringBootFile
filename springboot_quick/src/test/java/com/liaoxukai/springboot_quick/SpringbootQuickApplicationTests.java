package com.liaoxukai.springboot_quick;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootQuickApplicationTests {

//    @Autowired
////    private Person person;
////
////    @Value("#{1*3}")
////    private Integer age;

    Logger logger= LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {

        logger.trace("这里是trace...");
        logger.debug("这里是debug...");
        logger.info("这里是info...");
        logger.warn("这里是warn...");
        logger.error("这里是error...");

    }

}
