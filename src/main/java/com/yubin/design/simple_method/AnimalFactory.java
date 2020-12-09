package com.yubin.design.simple_method;

/**
 * 简单工厂-动物工厂类
 *
 * @author YUBIN
 * @create 2020-12-09
 */
public class AnimalFactory {

    // 简单工厂设计模式(负担太重、不符合开闭原则)
    public Animal createAnimal(String name) {
        if ("cat".equals(name)) {
            return new Cat();
        }
        if ("dog".equals(name)) {
            return new Dog();
        }
        if ("cow".equals(name)) {
            return new Cow();
        }
        return null;
    }
}
