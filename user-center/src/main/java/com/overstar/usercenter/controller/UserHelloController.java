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

    @Value("${username}")
    private String username;

    @Value("${length}")
    private int length;

    @GetMapping("/hello")
    public String helloUser(String userName){
        return userName+" how are you? this service form user service on port ->"+port;
    }


    @GetMapping("/configUsername")
    public String configUsername(){
        return "get remote config from config center service that length is -->" +length;
    }

    @GetMapping("/configLength")
    public String configLength(){
        return "get remote config from config center service that username is -->" +username;
    }
}
