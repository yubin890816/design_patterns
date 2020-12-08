package com.yubin.factorymethod;

/**
 * 交通工具之汽车
 *
 * @author YUBIN
 * @create 2020-12-06
 */
public class Car implements Moveable {

    @Override
    public void go() {
        System.out.println("Car go...");
    }
}
