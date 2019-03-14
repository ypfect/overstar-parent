package com.overstar.elasticsearch.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

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
}
