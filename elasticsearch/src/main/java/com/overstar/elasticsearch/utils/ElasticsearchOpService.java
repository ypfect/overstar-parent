package com.overstar.elasticsearch.utils;

import org.elasticsearch.action.admin.indices.alias.get.GetAliasesResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.metadata.AliasMetaData;
import org.elasticsearch.common.collect.ImmutableOpenMap;
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
}
