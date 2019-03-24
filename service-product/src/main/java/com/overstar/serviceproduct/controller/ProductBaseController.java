package com.overstar.serviceproduct.controller;

import com.alibaba.fastjson.JSON;
import com.overstar.commonbase.bean.RetOverStar;
import com.overstar.serviceproduct.bean.ProductQuery;
import com.overstar.serviceproduct.service.ProductBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/20 23:36
 */
@RestController
@RequestMapping("/pro")
public class ProductBaseController {

    @Autowired
    private ProductBaseService productBaseService;

    @PostMapping("getAllPro")
    public RetOverStar getAllProductBases(@RequestBody  ProductQuery query){
        return RetOverStar.success(productBaseService.getProductBaseAll(query));
    }

    public static void main(String[] args) {
        ProductQuery productQuery = new ProductQuery();
        productQuery.setPageNum(1);
        productQuery.setSize(25);
        System.out.println(JSON.toJSONString(productQuery));
    }

}
