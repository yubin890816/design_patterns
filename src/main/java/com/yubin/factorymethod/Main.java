package com.yubin.factorymethod;

/**
 * 客户端-测试类
 *
 * @author YUBIN
 * @create 2020-12-06
 */
public class Main {

    public static void main(String[] args) {
        //Moveable m = new Car();
        Moveable m = new Plane();
        m.go();
    }
}
