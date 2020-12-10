package com.yubin.design.proxy.dynamic_proxy;

/**
 * 被代理类
 *
 * @author YUBIN
 * @create 2020-12-10
 */
public class Dog implements Animal {

    @Override
    public void eat(String name) {
        System.out.println("dog eat " + name);
    }
}
