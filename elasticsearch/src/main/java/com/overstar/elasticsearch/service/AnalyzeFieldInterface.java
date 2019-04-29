package com.overstar.elasticsearch.service;

import java.util.Map;

/**
 * @Description 公共的分词接口 一个功能就是把字段分词然后装进map
 * @Author stanley.yu
 * @Date 2019/4/29 22:13
 */
public interface AnalyzeFieldInterface {
    Map<String,Object> analyzeField2SuggestMap(Map map,String field,String text);
}
