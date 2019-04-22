package com.overstar.elasticsearch.utils;

import com.alibaba.fastjson.JSON;
import com.overstar.commonbase.bean.EnumCode;
import com.overstar.commonbase.exception.ExceptionElasticSearch;
import com.overstar.commonbase.exception.ExceptionProduct;
import com.overstar.elasticsearch.constant.ProductSearchConstant;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesResponse;
import org.elasticsearch.action.admin.indices.get.GetIndexResponse;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.metadata.AliasMetaData;
import org.elasticsearch.common.collect.ImmutableOpenMap;
import org.elasticsearch.common.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/28 23:39
 */
@Component
public class ElasticsearchOpService {

    public static final Logger log = LoggerFactory.getLogger("run");

    @Value("${elasticsearch.conf.setting.name}")
    private String configJsonFileName;

    @Autowired
    private TransportClient transportClient;

    /**.
     * 根据别名获取索引列表
     * @param aliases
     * @return
     */
    public  List<String> getIndexesByAliases(String aliases){
        List<String> indexes = new ArrayList<>();
        //根据别名获取es中的所有索引
        GetAliasesResponse aliasesResponse = transportClient.admin().indices().prepareGetAliases(aliases).execute().actionGet();
        ImmutableOpenMap<String, List<AliasMetaData>> aliasesMap = aliasesResponse.getAliases();
        Iterator<String> aliasesKeys = aliasesMap.keysIt();
        //循环索引信息，找到别名是这个的返回
        while (aliasesKeys.hasNext()){
            String key = aliasesKeys.next();
            List<AliasMetaData> aliasMetaData = aliasesMap.get(key);
            for (AliasMetaData metaDatum : aliasMetaData) {
                String alias = metaDatum.getAlias();
                if (alias.equals(aliases)){
                    indexes.add(key);
                    break;
                }
            }
        }
        return indexes;
    }

    public BulkProcessor createBulkProcessor(){
        BulkProcessor.Builder es = BulkProcessor.builder(transportClient, new BulkProcessor.Listener() {
            @Override
            public void beforeBulk(long l, BulkRequest bulkRequest) {
                LoggerFactory.getLogger("es").info("bulkProcessing begin...");
            }

            @Override
            public void afterBulk(long l, BulkRequest bulkRequest, BulkResponse bulkResponse) {

            }

            @Override
            public void afterBulk(long l, BulkRequest bulkRequest, Throwable throwable) {
                LoggerFactory.getLogger("es").info("bulkProcessing end...");
            }
        });
        return es.setBulkActions(10000).setConcurrentRequests(0).build();

    }

    /**
     * 创建索引，索引名自己指定
     */
    public void createIndex(String index) {
        Map configJson = getConfigJson(configJsonFileName);
        if (StringUtils.isEmpty(configJson)){
            throw new ExceptionElasticSearch(EnumCode.EXCEPTION.getCode(),"瓦了，没找到json配置文件信息...");
        }
        log.info("-----------> init index by json config is starting....");
        transportClient.admin().indices().prepareCreate(index).setSettings(JSON.toJSONString(configJson.get("settings")), XContentType.JSON)
                .addMapping(ProductSearchConstant.TYPE,  JSON.toJSONString(configJson.get("mappings")), XContentType.JSON).execute().actionGet();
    }

    /**
     * 获取配置json文件
     * @param configJsonFileName
     * @return
     */
    public Map getConfigJson(String configJsonFileName) {
        return (Map) JSONHelper.resolveJsonFileToObject(configJsonFileName);
    }


    /**
     * 删除指定索引的别名
     */
    public void deleteAliases(String index, String alias) {
        transportClient.admin().indices().prepareAliases().removeAlias(index, alias).execute().actionGet();
    }

    /**
     * 删除索引
     */
    public void deleteIndex(String... indexes) {
        transportClient.admin().indices().prepareDelete(indexes).execute().actionGet();
    }

    public void addIntoAliases(String currentIndex,String aliases){
        transportClient.admin().indices().prepareAliases().addAlias(currentIndex,aliases).execute().actionGet();
    }

    /**
     * 删除该别名下面的老的index，新增新的index
     * @param oldIndex
     * @param newIndex
     * @param aliases
     */
    public void insertNewDeleteOld(String[] oldIndex,String newIndex,String aliases){
        transportClient.admin().indices().prepareAliases().removeAlias(oldIndex,aliases).addAlias(newIndex,aliases).execute().actionGet();
    }

    /**
     * 获取所有的索引
     * @return
     */
    public List<String> getAllIndexesName(){
        GetIndexResponse getIndexResponse = transportClient.admin().indices().prepareGetIndex().execute().actionGet();
        String[] indices = getIndexResponse.indices();
        return Arrays.asList(indices);
    }


    /**
     * 根据索引查询别名
     * @param indexName
     * @return
     */
    public String getAliasesNameByIndex(String indexName) {
        GetAliasesResponse aliasesResponse = transportClient.admin().indices().prepareGetAliases().execute().actionGet();
        //获取的map aliases,list<index>
        ImmutableOpenMap<String, List<AliasMetaData>> aliasesMap = aliasesResponse.getAliases();
        Iterator<String> aliasesKeys = aliasesMap.keysIt();
        while (aliasesKeys.hasNext()){
            String aliases = aliasesKeys.next();
            List<AliasMetaData> aliasMetaData = aliasesMap.get(aliases);
            for (AliasMetaData aliasMetaDatum : aliasMetaData) {
//                aliasMetaDatum.
            }
        }
        return null;

    }
}
