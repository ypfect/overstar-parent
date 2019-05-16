package com.overstar.elasticsearch.mapper.common;

import com.overstar.elasticsearch.bean.ProductDocument;
import com.overstar.serviceproduct.bean.ProductQuery;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/27 23:43
 */
public interface ProductDocumentMapper extends Mapper<ProductDocument>, MySqlMapper<ProductDocument> {

    List<ProductDocument> loadGoodsResource(ProductQuery productQuery);
    List<ProductDocument> loadGoodsResourceByProductIds(List<Integer> productIds);
}
