package com.overstar.elasticsearch.mapper.product;

import com.overstar.elasticsearch.dto.Viewspot;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface ViewspotMapper extends Mapper<Viewspot>, MySqlMapper<Viewspot> {

    List<Viewspot> loadAllViewspots(@Param("productStatus")Collection<Integer> productStatus);
}