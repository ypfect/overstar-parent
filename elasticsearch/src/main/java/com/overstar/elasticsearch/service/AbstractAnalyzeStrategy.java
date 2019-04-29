package com.overstar.elasticsearch.service;

import com.overstar.elasticsearch.constant.ProductSearchConstant;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeAction;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequest;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/4/29 22:12
 */
public abstract class AbstractAnalyzeStrategy implements AnalyzeFieldInterface{

    @Autowired
    private TransportClient transportClient;

    AnalyzeRequestBuilder initAnalyzeRequestBuilder(){
        AnalyzeRequestBuilder requestBuilder = new AnalyzeRequestBuilder(transportClient,AnalyzeAction.INSTANCE);
        requestBuilder.setIndex(ProductSearchConstant.INDEX_YPFECT);
        return requestBuilder;
    }

    String defaultAnalyzeType(){
        return "ik_smart";
    }

    @Override
    public Map<String,Object> analyzeField2SuggestMap(Map map, String field, String text) {
       return null;
    }
}
