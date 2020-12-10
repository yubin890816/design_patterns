package com.yubin.design.decorator;

/**
 * 装饰模式测试类
 *
 * @author YUBIN
 * @create 2020-12-10
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Sourceable source = new Source();
        Sourceable obj = new Decorator(source);
        obj.method();
    }
}
