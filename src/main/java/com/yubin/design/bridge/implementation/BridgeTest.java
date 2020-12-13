package com.yubin.design.bridge.implementation;

/**
 * 桥接模式
 *
 * @author YUBIN
 * @create 2020-12-13
 */
public class BridgeTest {

    public static void main(String[] args) {
        Implementor imple = new ConcreteImplementorA();
        Abstraction abs = new RefinedAbstraction(imple);
        abs.operation();
    }
}

/**
 * 实现化角色
 */
interface Implementor {
    public void operationImpl();
}

/**
 * 具体的实现化角色
 */
class ConcreteImplementorA implements Implementor {

    @Override
    public void operationImpl() {
        System.out.println("具体实现化(Concrete Implementor)角色被访问");
    }
}

/**
 * 抽象化角色
 */
abstract class Abstraction {
    protected Implementor imple;

    public Abstraction(Implementor imple) {
        this.imple = imple;
    }

    public abstract void operation();
}

/**
 * 扩展抽象化角色
 */
class RefinedAbstraction extends Abstraction {

    public RefinedAbstraction(Implementor imple) {
        super(imple);
    }

    @Override
    public void operation() {
        System.out.println("扩展抽象化(Refined Abstraction)角色被访问");
        imple.operationImpl();
    }

}