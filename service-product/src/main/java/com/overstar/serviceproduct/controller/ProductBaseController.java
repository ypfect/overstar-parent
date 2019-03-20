package com.overstar.serviceproduct.controller;

import com.overstar.serviceproduct.dto.ProductBase;
import com.overstar.serviceproduct.service.ProductBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/20 23:36
 */
@RestController
@RequestMapping
public class ProductBaseController {

    @Autowired
    private ProductBaseService productBaseService;

    @GetMapping("/getAllPro")
    public List<ProductBase> getAllProductBases(){
        return productBaseService.getProductBaseAll();
    }

}
