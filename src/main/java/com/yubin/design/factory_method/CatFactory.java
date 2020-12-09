package com.yubin.design.factory_method;

/**
 * 具体的工厂对象-猫工厂
 *
 * @author YUBIN
 * @create 2020-12-09
 */
public class CatFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}
