package com.overstar.elasticsearch.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/21 22:35
 */
@Configuration
@EnableTransactionManagement
public class MybatisConfig {

    public static final Logger LOG = LoggerFactory.getLogger(MybatisConfig.class);

    @Autowired
    private ApplicationContext context;

    @Primary
    @Bean(name = "product")
    @ConfigurationProperties(prefix ="spring.datasource.druid.product")
    public DataSource dataSourceProduct(){
        return DruidDataSourceBuilder.create().build();
    }


    @Bean(name = "order")
    @ConfigurationProperties(prefix ="spring.datasource.druid.order")
    public DataSource dataSourceOrder(){
        DruidDataSource build = DruidDataSourceBuilder.create().build();
        return build;
    }

//    @Bean
//    @ConditionalOnBean(DataSource.class)
//    public DynamicDataSource dataSource() {
//        Map<Object, Object> targetDataSources = new HashMap<>();
//        for (EnumDataSourceType dataSourceType : EnumDataSourceType.values()) {
//            boolean b = context.containsBean(dataSourceType.getDatasourceName());
//            if(!context.containsBean(dataSourceType.getDatasourceName())){
//                LOG.warn("setting db source：datasource 【{}】 not found ...",dataSourceType.getDatasourceName());
//                continue;
//            }
//            String datasourceName = dataSourceType.getDatasourceName();
//            LOG.info("sourceName ------------>{}",datasourceName);
//            DataSource dataSource = context.getBean(dataSourceType.getDatasourceName(), DruidDataSource.class);
//            if (dataSource != null) {
//                targetDataSources.put(dataSourceType, dataSource);
//            }
//        }
//        DynamicDataSource dataSource = new DynamicDataSource();
//        // 该方法是AbstractRoutingDataSource的方法
//        dataSource.setTargetDataSources(targetDataSources);
//        dataSource.setDefaultTargetDataSource(targetDataSources.get(EnumDataSourceType.PRODUCT));
//        return dataSource;
//    }

}
