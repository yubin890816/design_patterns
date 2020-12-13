package com.yubin.design.flyweight.implementation;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式
 *
 * @author YUBIN
 * @create 2020-12-13
 */
public class FlyweightPattern {

    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight f01 = factory.getFlyweight("k1");
        Flyweight f02 = factory.getFlyweight("k1");
        Flyweight f03 = factory.getFlyweight("k1");
        Flyweight f11 = factory.getFlyweight("k2");
        Flyweight f12 = factory.getFlyweight("k2");
        f01.operation(new UnsharedConcreteFlyweight("第1次调用k1。"));
        f02.operation(new UnsharedConcreteFlyweight("第2次调用k1。"));
        f03.operation(new UnsharedConcreteFlyweight("第3次调用k1。"));
        f11.operation(new UnsharedConcreteFlyweight("第1次调用k2。"));
        f12.operation(new UnsharedConcreteFlyweight("第2次调用k2。"));
    }
}

/**
 * 非享元角色
 */
class UnsharedConcreteFlyweight {

    private String info;

    public UnsharedConcreteFlyweight(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

/**
 * 抽象享元角色
 */
interface Flyweight {

    public void operation(UnsharedConcreteFlyweight state);
}

/**
 * 具体的享元角色
 */
class ConcreteFlyweight implements Flyweight {

    private String key;

    public ConcreteFlyweight(String key) {
        this.key = key;
        System.out.println("具体享元" + key + "被创建!");
    }


    @Override
    public void operation(UnsharedConcreteFlyweight state) {
        System.out.print("具体享元" + key + "被调用,");
        System.out.println("非相同信息是:" + state.getInfo());
    }
}

/**
 * 享元工厂角色
 */
class FlyweightFactory {

    private Map<String, Flyweight> flyweightMap = null;

    public FlyweightFactory() {
        this.flyweightMap = new HashMap<>();
    }

    public Flyweight getFlyweight(String key) {
        Flyweight flyweight = flyweightMap.get(key);
        if (flyweight == null) {
            flyweight = new ConcreteFlyweight(key);
            flyweightMap.put(key, flyweight);
        } else {
            System.out.println("具体享元" + key + "已经存在,被获取成功!");
        }
        return flyweight;
    }
}