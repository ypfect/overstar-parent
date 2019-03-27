package com.overstar.elasticsearch.mapper.product;

import com.overstar.elasticsearch.dto.Supplier;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface SupplierMapper extends Mapper<Supplier>, MySqlMapper<Supplier> {
}