package com.overstar.elasticsearch.controller;

import com.overstar.commonbase.bean.RetOverStar;
import com.overstar.elasticsearch.bean.ClusterHealth;
import com.overstar.elasticsearch.service.ClusterHealthService;
import com.overstar.elasticsearch.service.InitializationService.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/24 22:52
 */
@RestController
@RequestMapping("/es")
public class EsController {

    public static final Logger ESLOG = LoggerFactory.getLogger("run");

    @Autowired
    private ClusterHealthService clusterHealthService;
    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/cluster")
    public ClusterHealth listAll() {
        return clusterHealthService.clusterHealth();
    }

    @GetMapping
    public RetOverStar getCities(){
        Set<String> cities = cityService.getCities();
        ESLOG.info("es is ready...");
        return RetOverStar.success(cities);
    }
}
