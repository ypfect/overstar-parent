package com.overstar.elasticsearch.controller;

import com.overstar.commonbase.bean.RetOverStar;
import com.overstar.elasticsearch.bean.EsSearchQuery;
import com.overstar.elasticsearch.service.impl.ESService;
import com.overstar.serviceproduct.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @Description 搜索建议和搜索查询
 * @Author stanley.yu
 * @Date 2019/4/3 23:39
 */
@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private ESService esService;

    @PostMapping("/completion")
    public RetOverStar completionByKey(EsSearchQuery query){
        Set<String> suggestions = esService.completionByKey(query);
        return RetOverStar.sucess(200,suggestions);
    }

    @PostMapping("/productIdByKey")
    public RetOverStar productIdByKey(EsSearchQuery query){
        PageModel<LinkedHashMap<Integer, Double>> ret = esService.searchProductIds(query);
        return RetOverStar.sucess(200,ret);
    }

    public void  testsqo(){
        //testsao.var
        String testsao = "testsao";
        //testsao.null
        if (testsao == null) {

        }
        //testsao.notnull
        if (testsao != null) {

        }
        //strings.fori
        List<String> strings = Arrays.asList("sa", "asd", "dada");
        for (int i = 0; i < strings.size(); i++) {

        }

        //strings.size>9.if
        if (strings.size()>9) {

        }
    }

}
