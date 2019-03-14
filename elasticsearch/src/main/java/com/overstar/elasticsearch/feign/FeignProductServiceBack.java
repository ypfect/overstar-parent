package com.overstar.elasticsearch.feign;

import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/14 21:46
 */
@Service
public class FeignProductServiceBack implements FeignProductService{

    @Override
    public String feignHello() {
        return "this way is Terminated..";
    }

    @Override
    public String feignHystrixBack() {
        return "this way is Terminated..";
    }
}
