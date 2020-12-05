package com.yubin.design;

/**
 * 单例设计模式-静态内部类方式
 *
 * @author YUBIN
 * @create 2020-12-05
 */
public class Singleton04 {

    // 私有化构造函数
    private Singleton04(){}

    private static class StaticInnerClass {
        // 由JVM保证线程安全
        private static final Singleton04 instance = new Singleton04();
    }

    public static Singleton04 getInstance() {
        return StaticInnerClass.instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(Singleton04.getInstance());
            }).start();
        }
    }
}
