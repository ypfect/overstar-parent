package com.overstar.elasticsearch.utils;

import com.overstar.elasticsearch.constant.ProductSearchConstant;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesResponse;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.metadata.AliasMetaData;
import org.elasticsearch.common.collect.ImmutableOpenMap;
import org.elasticsearch.common.xcontent.XContentType;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/28 23:39
 */
@Component
public class ElasticsearchOpService {

    @Autowired
    private TransportClient transportClient;

    /**
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
                    indexes.add(alias);
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

            }
        });
        return es.setBulkActions(10000).setConcurrentRequests(0).build();

    }

    /**
     * 创建索引，索引名自己指定
     */
    public void createIndex(String index) {
        transportClient.admin().indices().prepareCreate(index).setSettings(ProductSearchConstant.Index.SETTINGS, XContentType.JSON)
                .addMapping(ProductSearchConstant.TYPE, ProductSearchConstant.Index.MAPPINGS, XContentType.JSON).execute().actionGet();
    }

    /**
     * 删除索引
     */
    public void deleteIndex(String... indexes) {
        transportClient.admin().indices().prepareDelete(indexes).execute().actionGet();
    }
}
