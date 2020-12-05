package com.yubin.design;

/**
 * 单例设计模式-懒汉式
 *
 * @author YUBIN
 * @create 2020-12-05
 */
public class Singleton03 {

    // 静态成员变量
    private static volatile Singleton03 instance;

    // 私有化构造函数
    private Singleton03(){}

    // 提供一个获取当前类实例的方法
    public static Singleton03 getInstance() {
        if (instance == null) {
            synchronized (Singleton03.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(100); // 测试代码
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Singleton03();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton03.getInstance());
            }).start();
        }
    }
}
