package com.yubin.design.decorator;

/**
 * 装饰类
 *
 * @author YUBIN
 * @create 2020-12-10
 */
public class Decorator implements Sourceable {

    private Sourceable source;

    public Decorator(Sourceable source) {
        this.source = source;
    }

    @Override
    public void method() {
        System.out.println("before decorator...");
        source.method();
        System.out.println("after decorator...");
    }
}
