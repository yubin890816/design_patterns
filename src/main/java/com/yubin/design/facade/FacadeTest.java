package com.yubin.design.facade;

/**
 * 客户端类
 *
 * @author YUBIN
 * @create 2020-12-11
 */
public class FacadeTest {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
        facade.methodC();
    }
}
