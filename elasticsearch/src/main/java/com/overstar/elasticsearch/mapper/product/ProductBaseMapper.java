package com.overstar.elasticsearch.mapper.product;

import com.overstar.elasticsearch.dto.ProductBase;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

public interface ProductBaseMapper extends Mapper<ProductBase>, MySqlMapper<ProductBase> {

    int getProductBaseTotal();

    //查询所有的产品ID
    List<Integer> getAllProductIds();
}