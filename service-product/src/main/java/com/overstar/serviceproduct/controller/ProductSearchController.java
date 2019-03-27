package com.overstar.serviceproduct.controller;

import com.overstar.commonbase.bean.RetOverStar;
import com.overstar.serviceproduct.service.Product4ESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/24 22:25
 */
@RestController
@RequestMapping("/es")
public class ProductSearchController {

    @Autowired
    private Product4ESService esService;

    @RequestMapping("/allRes")
    @ResponseBody
    public RetOverStar loadAllResource(){
        return RetOverStar.success(esService.searchResource());
    }

}
