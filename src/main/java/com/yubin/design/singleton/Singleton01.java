package com.yubin.design.singleton;

/**
 * 单例设计模式-饿汉式
 *
 * @author YUBIN
 * @create 2020-12-09
 */
public class Singleton01 {

    // 1、私有化构造函数
    private Singleton01(){}

    // 2、成员变量初始化本身对象
    private static Singleton01 instance = new Singleton01();

    // 3、对外提供公共方法获取实例
    public static Singleton01 getInstance() {
        return instance;
    }
}
