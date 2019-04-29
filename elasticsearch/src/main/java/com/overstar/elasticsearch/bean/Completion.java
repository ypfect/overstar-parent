package com.overstar.elasticsearch.bean;

/**
 * @Description 搜索建议的权重和内容
 * @Author stanley.yu
 * @Date 2019/4/29 21:19
 */
public class Completion {
    private String input;
    private double weight;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
