package com.yubin.design.adapter.class_adapter;

/**
 * 适配器类
 *
 * @author YUBIN
 * @create 2020-12-10
 */
public class Adapter extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("this is targetable method!");
    }
}
