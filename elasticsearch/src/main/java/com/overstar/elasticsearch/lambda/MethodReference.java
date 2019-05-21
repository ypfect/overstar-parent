package com.overstar.elasticsearch.lambda;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.overstar.elasticsearch.dto.ProductBase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 * @Description 方法引用
 * @Author stanley.yu
 * @Date 2019/5/17 11:14
 */
public class MethodReference {

    public static void main(String[] args) {
       List<ProductBase> bases = new ArrayList<>();
        ProductBase productBase1 = new ProductBase();
        productBase1.setProductNameZh("产品1");
        ProductBase productBase2 = new ProductBase();
        productBase2.setProductNameZh("产品2");
        ProductBase productBase3 = new ProductBase();
        productBase3.setProductNameZh("产品3");
        ProductBase productBase4 = new ProductBase();
        productBase4.setProductNameZh("产品4");
        bases.add(productBase1);
        bases.add(productBase3);
        bases.add(productBase2);
        bases.add(productBase4);
//        test1();
//        test2();
        test3(bases);
//        test4(bases);
    }

    //不接受参数直接返回。  supplier创建一个直接
    public static void test1(){

    }


    //接收两个参数
    public static void test2(){
    }


    /**
     * 这个可以定义方法，需要多步骤处理的时候。没有返回值
     */
    //接收两个参数
    public static void test3(List<ProductBase> bases){
        BiFunction<Integer, Integer, Integer> compare = Integer::compare;
        Integer apply = compare.apply(1, 2);
        System.out.println(apply);


    }


    /**
     * 没有返回值定义消费两次
     */
    public static void test4(List<ProductBase> bases){
        Function<ProductBase, String> getProductNameZh = ProductBase::getProductNameZh;
        Consumer<String> stringConsumer = (String xx) -> System.out.println(xx);//这个不是在lambda表示式子里面。所以只能传统写法
        bases.stream().forEach( bas->stringConsumer.accept(getProductNameZh.apply(bas)));
    }
}
