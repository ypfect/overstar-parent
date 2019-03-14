package com.overstar.serviceproduct.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/14 21:07
 */
@RestController
public class HelloController {
    int i =0;
    @Value("${server.port}")
    String port;

    @GetMapping("hello")
    public String sayHello(){
        return "from port :"+ port +"  ->service product<--";
    }


    @GetMapping("feignHello")
    public String feignHello(){
        return "from port : "+ port +"  ->service product feignHello<--";
    }

    /**
     * 测试feign的熔断效果，需要配置 true
     * @return
     * @throws InterruptedException
     */
    @GetMapping("feignHystrix")
    public String feignHystrixBack() throws InterruptedException {
        i++;
        if (i%2 ==0){
            Thread.sleep(50000);
        }
//        if (i%2 ==0){
//           int c = 1/0;
//        }
        return "from port : "+ port+"  ->service product fallback...<--";
    }
}
