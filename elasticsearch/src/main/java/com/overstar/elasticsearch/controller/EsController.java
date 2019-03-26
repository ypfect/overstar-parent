package com.overstar.elasticsearch.controller;

import com.overstar.elasticsearch.bean.ClusterHealth;
import com.overstar.elasticsearch.service.ClusterHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/24 22:52
 */
@RestController
@RequestMapping("/es")
public class EsController {

    @Autowired
    private ClusterHealthService clusterHealthService;

    @RequestMapping(value = "/cluster")
    public ClusterHealth listAll() {
        return clusterHealthService.clusterHealth();
    }
}
