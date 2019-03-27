package com.overstar.serviceproduct.mapper;

import com.overstar.serviceproduct.dto.Country;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface CountryMapper extends Mapper<Country>, MySqlMapper<Country> {
}