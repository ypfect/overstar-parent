package com.overstar.usercenter.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/3/14 22:40
 */
@RestController
@RequestMapping("/user")
public class UserHelloController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/hello")
    public String helloUser(String userName){
        return userName+" how are you? this service form user service on port ->"+port;
    }
}
