package com.yubin.factorymethod;

/**
 * 交通工具之飞机
 *
 * @author YUBIN
 * @create 2020-12-06
 */
public class Plane implements Moveable {
    @Override
    public void go() {
        System.out.println("Plane go...");
    }
}
