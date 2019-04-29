package com.overstar.elasticsearch.job;

import com.overstar.elasticsearch.service.YouKnow4SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/25 20:26
 */
@Service
public class AfterApplicationStarted implements ApplicationRunner {
    @Autowired
    private YouKnow4SearchService searchService;

    public static final Logger logger = LoggerFactory.getLogger(AfterApplicationStarted.class);
    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("application is ready...");
        searchService.initEsIndex();

    }
}
