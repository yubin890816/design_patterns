package com.yubin.design.proxy.static_proxy;

/**
 * 被代理类
 *
 * @author YUBIN
 * @create 2020-12-10
 */
public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("this is original method!");
    }
}
