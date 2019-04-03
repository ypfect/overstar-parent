package com.overstar.elasticsearch.controller;

import com.overstar.commonbase.bean.RetOverStar;
import com.overstar.elasticsearch.bean.ClusterHealth;
import com.overstar.elasticsearch.service.InitializationService.ClusterHealthService;
import com.overstar.elasticsearch.service.InitializationService.CityService;
import com.overstar.elasticsearch.service.YouKnow4SearchService;
import com.overstar.elasticsearch.utils.ElasticsearchOpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * @Description es容器的操作
 * @Author stanley.yu
 * @Date 2019/3/24 22:52
 */
@RestController
@RequestMapping("/es")
public class EsOpController {

    public static final Logger ESLOG = LoggerFactory.getLogger("run");

    @Autowired
    private ClusterHealthService clusterHealthService;
    @Autowired
    private CityService cityService;
    @Autowired
    private YouKnow4SearchService youKnow4SearchService;
    @Autowired
    private ElasticsearchOpService opService;

    @RequestMapping(value = "/cluster")
    public ClusterHealth listAll() {
        return clusterHealthService.clusterHealth();
    }

    @GetMapping("/getCities")
    public RetOverStar getCities(){
        Set<String> cities = cityService.getCities();
        ESLOG.info("es is ready...");
        return RetOverStar.success(cities);
    }

    /**
     * 调用初始化方法
     * @return
     */
    @GetMapping("/init")
    public RetOverStar initEs(){
        youKnow4SearchService.initEsIndex();
        ESLOG.info("es is ready...");
        return RetOverStar.success(null);
    }

    /**
     * 删除索引
     * @param index
     * @return
     */
    @GetMapping("/deleteIndex")
    public RetOverStar deleteIndex(String index){
        opService.deleteIndex(index);
        return RetOverStar.sucess(200,"you eat");
    }

    /**
     * 删除索引和别名的关联关系
     * @param index
     * @param aliName
     * @return
     */
    @GetMapping("/deleteIndexInAli")
    public RetOverStar deleteIndex(String index,String aliName){
        opService.deleteAliases(index,aliName);
        return RetOverStar.sucess(200,"you eat");
    }

    /**
     * 获取所有的索引
     * @return
     */
    @GetMapping("/getIndexes")
    public RetOverStar getAllIndexes(){
        List<String> allIndexesName = opService.getAllIndexesName();
        return RetOverStar.sucess(200,allIndexesName);
    }

    /**
     * 获取别名下的所有索引
     * @param aliases
     * @return
     */
    @GetMapping("/getIndexesByAliases")
    public RetOverStar getIndexesByAliases(String aliases){
        List<String> indexesByAliases = opService.getIndexesByAliases(aliases);
        return RetOverStar.sucess(200,indexesByAliases);
    }

    @GetMapping("/getAliasesNameByIndex")
    public RetOverStar getAliasesNameByIndex(String indexName){
        String aliasesName = opService.getAliasesNameByIndex(indexName);
        return RetOverStar.sucess(200,aliasesName);
    }


}
