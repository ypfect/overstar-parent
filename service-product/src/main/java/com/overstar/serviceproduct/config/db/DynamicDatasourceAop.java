package com.overstar.serviceproduct.config.db;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/20 22:28
 */
@Aspect
@Configuration
public class DynamicDatasourceAop {

    public static final Logger LOG = LoggerFactory.getLogger(DynamicDatasourceAop.class);

    @Around("@annotation(com.overstar.serviceproduct.config.db.TargetDataSource) && @annotation(targetDataSource)")
    public Object sourceCutPoint(ProceedingJoinPoint point,TargetDataSource targetDataSource) throws Throwable {
        LOG.info("exchange datasource...");
        return point.proceed();
    }
}
