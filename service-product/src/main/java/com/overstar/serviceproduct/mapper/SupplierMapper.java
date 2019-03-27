package com.overstar.serviceproduct.mapper;

import com.overstar.serviceproduct.dto.Supplier;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface SupplierMapper extends Mapper<Supplier>, MySqlMapper<Supplier> {
}