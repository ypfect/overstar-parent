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
 * @Description 默认分词 建立suggest
 * @Author stanley.yu
 * @Date 2019/4/29 22:24
 */
public abstract class BaseAnalyzeService extends AbstractAnalyzeStrategy {

    //获取各个字段基本的分词
    abstract String baseAnalyzeType();

    //基本分词
    List<Map<String,Double>> doBaseAnalyze(String field,String text) throws ExecutionException, InterruptedException {
        List<Map<String,Double>> res = new ArrayList<>();
        AnalyzeRequestBuilder analyzeRequestBuilder = initAnalyzeRequestBuilder();
        basicAnalyze(res,analyzeRequestBuilder,text);
        keywordLevelSuggestText(res,field,text);
        //todo 都需要的一个全文 一个ik 或者其他的基本分词  然后骚一点的可以加特殊的filter 和 tokenizer
        return res;
    }


    void basicAnalyze(List<Map<String,Double>> res ,AnalyzeRequestBuilder analyzeRequestBuilder,String text)
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

            HashMap<String, Double> doubleHashMap = new HashMap<>();
            doubleHashMap.put(p.getTerm(), (double) (p.getTerm().length()*2));
            res.add(doubleHashMap);
//            Completion completion = new Completion();
//            completion.setInput(p.getTerm());
//            completion.setWeight(p.getTerm().length()*10);//算法改进下。我草    todo
        });
    }

    /**
     * 不分词的处理
     * @param res
     * @param fullText
     */
    void keywordLevelSuggestText(List<Map<String,Double>> res,String field,String fullText){
        HashMap<String, Double> doubleHashMap = new HashMap<>();
        //根据field分数设置值
        EnumFieldSuggest enumFieldSuggest = EnumFieldSuggest.valueOf(field);
        double weight = enumFieldSuggest.getWeight();
        doubleHashMap.put(fullText,weight);//搞错了，不能这样玩，。需要是 input xxx  weight xxx
    }
}
