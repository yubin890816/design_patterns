package com.yubin.design;

/**
 * 单例设计模式-饿汉式之采用静态代码块实例化单例
 *
 * @author YUBIN
 * @create 2020-12-05
 */
public class Singleton02 {

    // 采用静态代码块的方式实例化单例 跟Singleton01一个意思
    private static final Singleton02 instance;

    static {
        instance = new Singleton02();
    }

    // 私有化构造函数,使其它类不能new它
    private Singleton02() {}

    public static Singleton02 getInstance() {
        return instance;
    }
}
