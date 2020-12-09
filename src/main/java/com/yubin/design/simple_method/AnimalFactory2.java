package com.yubin.design.simple_method;

/**
 * 静态方法工厂
 *
 * @author YUBIN
 * @create 2020-12-09
 */
public class AnimalFactory2 {

    public static Dog createDog() {
        return new Dog();
    }

    public static Cat createCat() {
        return new Cat();
    }

    public static Cow createCow() {
        return new Cow();
    }
}
