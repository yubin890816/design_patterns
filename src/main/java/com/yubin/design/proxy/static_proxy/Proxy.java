package com.yubin.design.proxy.static_proxy;

/**
 * 代理类
 *
 * @author YUBIN
 * @create 2020-12-10
 */
public class Proxy implements Sourceable {

    private Sourceable source;

    public Proxy() {
        this.source = new Source();
    }

    @Override
    public void method() {
        before();
        source.method();
        after();
    }

    private void before() {
        System.out.println("before proxy!");
    }

    private void after() {
        System.out.println("after proxy!");
    }
}
