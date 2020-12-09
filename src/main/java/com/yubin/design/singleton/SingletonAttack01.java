package com.yubin.design.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 如何破坏一个单例-反射攻击
 *
 * @author YUBIN
 * @create 2020-12-09
 */
public class SingletonAttack01 {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        reflectionAttack();
    }

    public static void reflectionAttack() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<Singleton03> constructor = Singleton03.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton03 instance1 = constructor.newInstance();
        Singleton03 instance2 = constructor.newInstance();
        System.out.println(instance1 == instance2);
    }
}
