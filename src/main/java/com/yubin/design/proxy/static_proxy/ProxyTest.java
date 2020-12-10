package com.yubin.design.proxy.static_proxy;

/**
 * 静态代理测试类
 *
 * @author YUBIN
 * @create 2020-12-10
 */
public class ProxyTest {

    public static void main(String[] args) {
        Sourceable source = new Proxy();
        source.method();
    }
}
