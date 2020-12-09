package com.yubin.design.singleton;

import java.io.Serializable;

/**
 * 懒汉式单例-双重检查锁DCL
 *
 * @author YUBIN
 * @create 2020-12-09
 */
public class Singleton03 implements Serializable {

    // 1、私有化构造函数
    private Singleton03(){}

    // 2、定义私有静态成员变量（先不初始化）
    private static volatile Singleton03 instance;
    //private static volatile transient Singleton03 instance;

    // 3、对外提供公共方法获取实例
    public static Singleton03 getInstance() {
        if (instance == null) {
            synchronized (Singleton03.class) {
                // 这里再加一次判断是因为在并发的情况下可能会有其它的线程等待于锁
                if (instance == null) {
                    /**
                     * instance = new Singleton03(); 包含了如下3步操作
                     * 1.new：开辟JVM堆中的内存空间
                     * 2.将内存空间初始化（指的就是对象的成员变量初始化为0值）
                     * 3.将内存空间地址（引用地址）赋值给引用类型的变量
                     *
                     * 在new对象的时候，JIT即时编译器会根据运行情况，对对象创建的过程进行指令重排序2和3的步骤可能会变成先执行3再执行2
                     * volatile关键字
                     *  作用一：禁止被它修饰的变量发生指令重排操作。是通过内存屏障去完成的禁止指令重排序。
                     *  作用二：简单理解是禁止CPU缓存使用，其实是被volatile关键字修饰的变量，在修改之前，都需要将最新CPU缓存中的数据刷新到主内存中。
                     */
                    instance = new Singleton03();
                }
            }
        }
        return instance;
    }

    /*private Object readResolve() {
        return instance;
    }*/
}
