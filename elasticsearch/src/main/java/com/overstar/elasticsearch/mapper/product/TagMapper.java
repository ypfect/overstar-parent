package com.overstar.elasticsearch.mapper.product;

import com.overstar.elasticsearch.dto.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/28 21:29
 */
public interface TagMapper {
    List<Tag> loadAllTags(@Param("productStatus")Collection<Integer> productStatus);
}
