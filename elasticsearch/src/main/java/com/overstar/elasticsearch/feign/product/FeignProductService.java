package com.overstar.elasticsearch.feign.product;

import com.overstar.commonbase.bean.RetOverStar;
import com.overstar.serviceproduct.bean.ProductQuery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/14 21:29
 */
@FeignClient(value = "product-service",fallback = FeignProductServiceBack.class)
public interface FeignProductService {

    @GetMapping("feignHello")
    String feignHello();

    @GetMapping("feignHystrix")
    String feignHystrixBack();

    @PostMapping("/pro/getAllPro")
    RetOverStar getAllProductBases(ProductQuery query);

    @RequestMapping("/es/allRes")
    RetOverStar loadAllResource();
}
