package com.overstar.elasticsearch.controller;

import com.overstar.elasticsearch.feign.FeignProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/14 21:27
 */
@RestController
public class ProductSearchController {

    @Resource
    private FeignProductService productService;

    @GetMapping("/feign")
    public String feignTestByLocalInterface(){
        String s = productService.feignHello();
        return s;
    }

    @GetMapping("/feignHystrix")
    public String feignHystrixByLocaltion(){
        String s = productService.feignHystrixBack();
        return s;
    }


    @GetMapping("/testHello")
    public String testHello(String test){
      return test+" hello this is service ...";
    }
}
