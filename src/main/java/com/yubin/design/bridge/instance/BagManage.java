package com.yubin.design.bridge.instance;

/**
 * 用桥接（Bridge）模式模拟女士皮包的选购
 *
 * @author YUBIN
 * @create 2020-12-13
 */
public class BagManage {
    public static void main(String[] args) {
        Color color = new Red();
        Bag bag = new HandBag();
        bag.setColor(color);
        System.out.println(bag.getName());

        color = new Yellow();
        bag = new HandBag();
        bag.setColor(color);
        System.out.println(bag.getName());

        color = new Red();
        bag = new Wallet();
        bag.setColor(color);
        System.out.println(bag.getName());

        color = new Yellow();
        bag = new Wallet();
        bag.setColor(color);
        System.out.println(bag.getName());
    }
}

/**
 * 实现化角色：颜色
 */
interface Color {
    String getColor();
}

/**
 * 具体实现化角色：黄色
 */
class Yellow implements Color {
    public String getColor() {
        return "yellow";
    }
}

/**
 * 具体实现化角色：红色
 */
class Red implements Color {
    public String getColor() {
        return "red";
    }
}

/**
 * 抽象化角色：包
 */
abstract class Bag {
    protected Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract String getName();
}

//扩展抽象化角色：挎包
class HandBag extends Bag {
    public String getName() {
        return color.getColor() + "-HandBag";
    }
}

//扩展抽象化角色：钱包
class Wallet extends Bag {
    public String getName() {
        return color.getColor() + "-Wallet";
    }
}