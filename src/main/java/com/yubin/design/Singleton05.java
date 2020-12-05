package com.yubin.design;

/**
 * 单例设计模式-枚举方式
 * 不但可以保证线程安全,也可以防止序列化和反序列化的破坏
 *
 * @author YUBIN
 * @create 2020-12-05
 */
public enum Singleton05 {
    INSTANCE,
    ;

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(Singleton05.INSTANCE.hashCode());
            }).start();
        }
    }
}
