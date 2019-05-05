package com.overstar.elasticsearch.service.field;

import com.overstar.elasticsearch.service.BaseAnalyzeService;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequestBuilder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description 产品中文名
 * @Author stanley.yu
 * @Date 2019/4/29 22:38
 */
@Service
public class ProductNameZhHandler extends BaseAnalyzeService {
    @Override
    public String baseAnalyzeType() {
        return "ik_smart";
    }

    /**
     * 根据字段的分词策略不同-返回的数据进行不同weight的配置
     * @param text
     * @return
     */
    @Override
    protected List<Map<String, Object>> configFieldAnalyzeCustomMap(String text) {
        AnalyzeRequestBuilder analyzeRequestBuilder = initAnalyzeRequestBuilder();
        HashMap<String, Object> edgeNGramFilter = new HashMap<>();
        edgeNGramFilter.put("type","edgeNGram");
        edgeNGramFilter.put("min_gram",2);
        edgeNGramFilter.put("max_gram",15);
        edgeNGramFilter.put("token_chars","[\"letter\", \"digit\"]");
        analyzeRequestBuilder.addTokenFilter(edgeNGramFilter);
        return null;
    }





}
