package com.overstar.elasticsearch.mapper.product;

import com.overstar.elasticsearch.dto.City;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface CityMapper extends Mapper<City>, MySqlMapper<City> {

    List<City> loadAllCities(@Param("productStatus")Collection<Integer> productStatus);
}