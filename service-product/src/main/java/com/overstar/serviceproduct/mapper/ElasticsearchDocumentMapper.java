package com.overstar.serviceproduct.mapper;

import com.overstar.serviceproduct.bean.ProductDocument;

import java.util.List;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/27 14:08
 */
public interface ElasticsearchDocumentMapper {

    List<ProductDocument> loadProResource();
}
