package com.overstar.elasticsearch.service;

import com.overstar.elasticsearch.api.ElasticSearchService;
import com.overstar.elasticsearch.bean.EsSearchQuery;
import com.overstar.serviceproduct.utils.PageModel;

import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/24 22:51
 */
public class ESService implements ElasticSearchService {
    @Override
    public Set<String> completionByKey(EsSearchQuery esSearchQuery) {
        return null;
    }

    @Override
    public PageModel<LinkedHashMap<Integer, Double>> searchProductIds(EsSearchQuery esSearchQuery) {
        return null;
    }
}
