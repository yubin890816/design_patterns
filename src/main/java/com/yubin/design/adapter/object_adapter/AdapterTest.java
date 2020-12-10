package com.yubin.design.adapter.object_adapter;

/**
 * 对象适配器模式测试类
 *
 * @author YUBIN
 * @create 2020-12-10
 */
public class AdapterTest {

    public static void main(String[] args) {
        Source source = new Source();
        Targetable target = new Wrapper(source);
        target.method1();
        target.method2();
    }
}
