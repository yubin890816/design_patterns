package com.yubin.design.adapter.object_adapter;

/**
 * 包装器类
 *
 * @author YUBIN
 * @create 2020-12-10
 */
public class Wrapper implements Targetable {

    private Source source;

    public Wrapper(Source source) {
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is targetable method!");
    }
}
