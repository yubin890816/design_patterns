package com.yubin.design;

/**
 * 单例设计模式---饿汉式
 *
 * @author YUBIN
 * @create 2020-12-05
 */
public class Singleton01 {

    // 私有成员变量  类加载到内存后,就实例化一个单例,JVM保证线程安装
    private static final Singleton01 instance = new Singleton01();

    // 私有化构造函数(出了这个类,其它类就不能再new它了)
    private Singleton01(){}

    // 提供一个静态方法获取当前类的实例
    public static Singleton01 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton01 instance1 = Singleton01.getInstance();
        Singleton01 instance2 = Singleton01.getInstance();
        System.out.println(instance1 == instance2);
    }
}
