package com.yubin.design.decorator;

/**
 * 被装饰类
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
