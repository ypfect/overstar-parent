package com.overstar.serviceproduct.config.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;

/**
 * @Description private Map<Object, Object> targetDataSources;
 * 动态切换数据源--提供线程基本的数据源设置
 * @Author stanley.yu
 * @Date 2019/3/20 22:13
 */
public class DynamiDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<EnumDataSourceType> datasource = new ThreadLocal<>();

    //提供方法进行设置值
    public static void setDatasource(EnumDataSourceType datasourceEnum){
        datasource.set(datasourceEnum);
    }

    //提供方法进行设置值
    public static EnumDataSourceType getDatasource(){
        return datasource.get();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getDatasource();
    }
}
