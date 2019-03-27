package com.overstar.elasticsearch.mapper.product;

import com.overstar.elasticsearch.dto.ProductBase;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface ProductBaseMapper extends Mapper<ProductBase>, MySqlMapper<ProductBase> {
}