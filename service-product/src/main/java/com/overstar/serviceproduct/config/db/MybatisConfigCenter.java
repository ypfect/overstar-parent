package com.overstar.serviceproduct.config.db;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/20 21:52
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.overstar.serviceproduct.mapper", sqlSessionTemplateRef = "goodsSqlSessionTemplate")
public class MybatisConfigCenter {

    @Primary
    @Bean("productSource")
    @ConfigurationProperties("spring.datasource.product")
    public DataSource dataSourceProduct(){
        return DruidDataSourceBuilder.create().build();
    }
    @Bean("userSource")
    @ConfigurationProperties("spring.datasource.user")
    public DataSource dataSourceUser(){
        return DruidDataSourceBuilder.create().build();
    }


    @Primary
    @Bean(name = "productSourceTransactionManager")
    public DataSourceTransactionManager setTransactionManager(@Qualifier("productSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "productSourceSqlSessionFactory")
    @Primary
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("productSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/*.xml"));
        return bean.getObject();
    }

    @Primary
    @Bean(name = "productSourceSqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("productSourceSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
