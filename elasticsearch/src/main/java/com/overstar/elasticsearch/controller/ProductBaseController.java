package com.overstar.elasticsearch.controller;

import com.overstar.commonbase.bean.RetOverStar;
import com.overstar.elasticsearch.feign.product.FeignProductService;
import com.overstar.serviceproduct.bean.ProductQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/21 22:15
 */
@RestController
@RequestMapping("/es")
public class ProductBaseController {

    @Autowired
    private FeignProductService productService;

    @GetMapping("/allPro")
    public RetOverStar findProByProService(@RequestBody ProductQuery query){
        return productService.getAllProductBases(query);
    }
}
