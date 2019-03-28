package com.overstar.elasticsearch.mapper.product;

import com.overstar.elasticsearch.dto.Country;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface CountryMapper extends Mapper<Country>, MySqlMapper<Country> {

    List<Country> loadAllCountries(@Param("productStatus")Collection<Integer> productStatus);
}