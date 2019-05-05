package com.overstar.elasticsearch.service.field;

import com.overstar.elasticsearch.service.BaseAnalyzeService;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequestBuilder;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description 产品中文名
 * @Author stanley.yu
 * @Date 2019/4/29 22:38
 */
@Service
public class ProductNameZhHandler extends BaseAnalyzeService {
    @Override
    public String baseAnalyzeType() {
        return "ik_smart";
    }

    /**
     * 根据字段的分词策略不同-返回的数据进行不同weight的配置
     *
     * 两种策略：1. 中文名直接根据 ik-smart分词的进行edgeNGram 然后索引token 中文这个其实还是很靠谱的，其实没有必要  我 我爱 我爱北 我爱北京
     *      直接分词成 我爱北京 天安门 这种。我提示：我爱北京  天 提示：天安门这种
     *
     *           2. 但是目前有问题，不能根据‘我爱北京天安门这种进行分词操作’ 一个一个的  我 我爱 我爱北 我爱北京 这种其实可以自定义实现，也不复杂。但是没有必要
     *
     *           3.拼音首字母的其实还是可以搞搞的 w wa wab wabj 这种
     *
     *           4.以上好像都没必要。suggest就只需要匹配 全名称这种，还有ik分词之后的这种就ok  马蜂窝还有统计相关的
     * @param text
     * @return
     */
    @Override
    public List<Map<String, Object>> configFieldAnalyzeCustomMap(String text) {
        AnalyzeRequestBuilder analyzeRequestBuilder = initAnalyzeRequestBuilder();
        HashMap<String, Object> edgeNGramFilter = new HashMap<>();
        edgeNGramFilter.put("type","edgeNGram");
        edgeNGramFilter.put("min_gram",2);
        edgeNGramFilter.put("max_gram",8);
//        edgeNGramFilter.put("token_chars","[\"letter\", \"digit\"]");
//        analyzeRequestBuilder.setTokenizer(edgeNGramFilter);
//
//        analyzeRequestBuilder.setExplain(true);
//        analyzeRequestBuilder.addTokenFilter("edgeNGramFilter");
//        analyzeRequestBuilder.setAnalyzer("ik");
        analyzeRequestBuilder.setText(text);
//        analyzeRequestBuilder.setAnalyzer("simple");
//        analyzeRequestBuilder.addCharFilter("html_strip");
        analyzeRequestBuilder.setTokenizer("ik_smart");
//        analyzeRequestBuilder.setTokenizer("edgeNGram");
        analyzeRequestBuilder.addTokenFilter(edgeNGramFilter);
        AnalyzeResponse analyzeTokens = analyzeRequestBuilder.execute().actionGet();
        analyzeTokens.getTokens().stream().forEach(p-> System.out.println(p.getTerm()));
        return null;
    }





}
