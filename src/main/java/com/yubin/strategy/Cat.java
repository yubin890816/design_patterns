package com.yubin.strategy;

/**
 * 猫的实体类
 *
 * @author YUBIN
 * @create 2020-12-06
 */
public class Cat {

    public int weight;

    public int height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
