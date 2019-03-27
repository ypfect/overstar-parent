package com.overstar.elasticsearch.api;

import com.overstar.commonbase.bean.PageQuery;
import com.overstar.elasticsearch.bean.ProductDocument;
import com.overstar.serviceproduct.bean.ProductQuery;

import java.util.List;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/28 0:24
 */
public interface IInitElasticsearchDataService {

    List<ProductDocument> iiiinitProData4Es(ProductQuery query);
}
