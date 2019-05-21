package com.overstar.elasticsearch.lambda;

import com.google.common.base.Supplier;

import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;

/**
 * @Description lambda 语法测试
 * @Author stanley.yu
 * @Date 2019/5/17 11:12
 */
public class Grammar {

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }

    //不接受参数直接返回。  supplier创建一个直接
    public static void test1(){
        Supplier<Integer> integerSupplier = () -> 1;
        System.out.println(integerSupplier.get());
    }


    //接收两个参数
    public static void test2(){
        IntBinaryOperator intBinaryOperator = (int a, int b) -> a + b;
        System.out.println(intBinaryOperator.applyAsInt(5,6));
    }


    /**
     * 这个可以定义方法，需要多步骤处理的时候。没有返回值
     */
    //接收两个参数
    public static void test3(){
        BiConsumer<String, String> stringStringBiConsumer = (String a, String b) -> {
            System.out.println(b);
            System.out.println(a);
        };

        stringStringBiConsumer.accept("lambda","niup");
    }


    /**
     * 没有返回值定义消费两次
     */
    public static void test4(){
        IntConsumer intConsumer = (int x) -> String.valueOf(x);
        IntConsumer intConsumer1 = (int y) -> System.out.println(y + "lambda");
        IntConsumer intConsumer2 = intConsumer.andThen(intConsumer1);
        intConsumer2.accept(50);
    }




}
