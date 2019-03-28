package com.overstar.elasticsearch.constant;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/28 21:33
 */
public interface ProductSearchConstant {

    //线上单独售卖状态
    Set<Integer> ONLINE_STATUS = Sets.newHashSet(200);
    //默认最多国家个数
    Integer COUNTRIES_MAX = 100;
    //默认最多城市个数
    Integer CITIES_MAX = 300;
    //最低分数
    float MIN_SCORE = 500f;

}
