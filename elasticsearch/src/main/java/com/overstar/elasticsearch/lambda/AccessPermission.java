package com.overstar.elasticsearch.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @Description 访问权限
 * @Author stanley.yu
 * @Date 2019/5/17 11:13
 */
public class AccessPermission {

    @FunctionalInterface
    interface Sout{
        void sout(String s);
    }

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    /**
     * 这个可以定义方法，需要多步骤处理的时候。没有返回值
     */
    //接收两个参数
    public static void test3(){
        List<String> strings = Arrays.asList("asda", "wqdqadw");
        Sout sout = (String X)-> System.out.println(X);
        strings.stream().forEach(sout::sout);
    }
}
