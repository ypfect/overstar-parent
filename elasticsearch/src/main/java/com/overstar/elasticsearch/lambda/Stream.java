package com.overstar.elasticsearch.lambda;

import org.apache.commons.lang.time.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.overstar.elasticsearch.lambda.MethodReference.test1;

/**
 * @Description
 * @Author stanley.yu
 * @Date 2019/5/17 16:11
 */
public class Stream {

    public static void main(String[] args) {
        ArrayList<Date> dates = new ArrayList<>();
        dates.add(new Date());
        dates.add(DateUtils.addDays(new Date(),1));
        dates.add(DateUtils.addDays(new Date(),2));
        dates.add(DateUtils.addDays(new Date(),3));
        dates.add(DateUtils.addDays(new Date(),4));
        dates.add(DateUtils.addDays(new Date(),5));
        dates.add(DateUtils.addDays(new Date(),6));
        dates.add(DateUtils.addDays(new Date(),7));
        dates.add(DateUtils.addDays(new Date(),8));
        dates.add(DateUtils.addDays(new Date(),9));
        test1(dates);
    }

    public static void test1(ArrayList<Date> dates){

        List<Date> collect = dates.stream().filter(date -> date.after(DateUtils.addDays(new Date(),5))

            || date.before(DateUtils.addDays(new Date(),3))).collect(Collectors.toList());
        System.out.println(collect);
    }
}
