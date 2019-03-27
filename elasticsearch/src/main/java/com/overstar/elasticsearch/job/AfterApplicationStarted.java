package com.overstar.elasticsearch.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/25 20:26
 */
public class AfterApplicationStarted implements ApplicationRunner {

    public static final Logger logger = LoggerFactory.getLogger(AfterApplicationStarted.class);
    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("application is ready...");
    }
}
