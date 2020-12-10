package com.yubin.design.adapter.class_adapter;

/**
 * 适配器测试类
 *
 * @author YUBIN
 * @create 2020-12-10
 */
public class AdapterTest {

    public static void main(String[] args) {
        Targetable target = new Adapter();
        target.method1();
        target.method2();
    }
}
