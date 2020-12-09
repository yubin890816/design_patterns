package com.yubin.design.singleton;

/**
 * 懒汉式单例-静态内部类方式
 *
 * @author YUBIN
 * @create 2020-12-09
 */
public class Singleton02 {

    // 私有化构造函数
    private Singleton02(){}

    // 此处使用一个内部类来维护单例 JVM在类加载的时候是互斥的，所以可以由此保证线程安全问题
    private static class SingletonFactory {
        private static Singleton02 instance = new Singleton02();
    }

    // 对外提供公共方法获取实例
    public static Singleton02 getInstance() {
        return SingletonFactory.instance;
    }
}
