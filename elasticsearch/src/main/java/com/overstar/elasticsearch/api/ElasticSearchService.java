package com.overstar.elasticsearch.api;

import com.overstar.elasticsearch.bean.EsSearchQuery;
import com.overstar.serviceproduct.utils.PageModel;

import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/24 22:44
 */
public interface ElasticSearchService {

    Set<String> completionByKey(EsSearchQuery esSearchQuery);

    PageModel<LinkedHashMap<Integer,Double>> searchProductIds(EsSearchQuery esSearchQuery);
}
