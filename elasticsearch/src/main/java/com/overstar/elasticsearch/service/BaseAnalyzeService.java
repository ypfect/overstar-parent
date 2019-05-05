package com.overstar.elasticsearch.service;

import com.overstar.elasticsearch.constant.EnumFieldSuggest;
import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequestBuilder;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @Description suggest 分词中间处理类：包含最基本的分词 以及不分词完整text
 * eg: 我爱大中国
 * 1. 不分词 --> input= "我爱大中国"
 * 2. 基本分词 ->ik_smart   我爱 大中国  我爱大中国
 * @Author stanley.yu
 * @Date 2019/4/29 22:24
 */
public abstract class BaseAnalyzeService extends AbstractAnalyzeStrategy {

    //获取各个字段基本的分词
    public abstract String baseAnalyzeType();

    //获取字段个性化配置设置
    protected  abstract  List<Map<String,Object>> configFieldAnalyzeCustomMap(String text);

    //基本分词
    List<Map<String,Object>> doBaseAnalyze(String field,String text) throws ExecutionException, InterruptedException {
        List<Map<String,Object>> res = new ArrayList<>();
        AnalyzeRequestBuilder analyzeRequestBuilder = initAnalyzeRequestBuilder();
        basicAnalyze(res,analyzeRequestBuilder,text);
        keywordLevelSuggestText(res,field,text);
        List<Map<String, Object>> customMap = configFieldAnalyzeCustomMap(text);
        res.addAll(customMap);
        //todo 都需要的一个全文 一个ik 或者其他的基本分词  然后骚一点的可以加特殊的filter 和 tokenizer
        return res;
    }


    void basicAnalyze(List<Map<String,Object>> res ,AnalyzeRequestBuilder analyzeRequestBuilder,String text)
            throws ExecutionException, InterruptedException {
        analyzeRequestBuilder.setText(text);
        //根据各自的基本分词获取。获取不到就获取默认的分词器
        analyzeRequestBuilder.setAnalyzer(baseAnalyzeType() == null ? defaultAnalyzeType():baseAnalyzeType());
        ActionFuture<AnalyzeResponse> execute = analyzeRequestBuilder.execute();
        AnalyzeResponse analyzeTokens = execute.get();
        //获取分词结果
        List<AnalyzeResponse.AnalyzeToken> tokens = analyzeTokens.getTokens();
        tokens.stream().forEach(p->{
            if ("<NUM>".equals(p.getType()) || p.getTerm().length()<2){
                return;//lambda return等于 break continue
            }
            HashMap<String, Object> suggestMap = new HashMap<>();
            suggestMap.put("input",p.getTerm());
            suggestMap.put("weight",p.getTerm().length()*2);
            res.add(suggestMap);
        });
    }

    /**
     * 不分词的处理
     * @param res
     * @param fullText
     */
    void keywordLevelSuggestText(List<Map<String,Object>> res,String field,String fullText){
        HashMap<String, Object> suggestMap = new HashMap<>();
        //根据field分数设置值
        EnumFieldSuggest enumFieldSuggest = EnumFieldSuggest.valueOf(field);
        double weight = enumFieldSuggest.getWeight();
        suggestMap.put("input",fullText);
        suggestMap.put("weight",weight);
        res.add(suggestMap);
    }
}
