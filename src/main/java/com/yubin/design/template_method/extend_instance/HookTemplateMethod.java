package com.yubin.design.template_method.extend_instance;

/**
 * 含钩子方法的模板方法模式
 *
 * @author YUBIN
 * @create 2020-12-14
 */
public class HookTemplateMethod {

    public static void main(String[] args) {
        HookAbstractClass tm = new HookConcreteClass();
        tm.templateMethod();
    }
}

/**
 * 含钩子方法的抽象类
 */
abstract class HookAbstractClass {
    //模板方法
    public void templateMethod() {
        abstractMethod1();
        hookMethod1();
        if (hookMethod2()) {
            specificMethod();
        }
        abstractMethod2();
    }

    //具体方法
    public void specificMethod() {
        System.out.println("抽象类中的具体方法被调用...");
    }

    //钩子方法1
    public void hookMethod1() {
    }

    //钩子方法2
    public boolean hookMethod2() {
        return true;
    }

    //抽象方法1
    public abstract void abstractMethod1();

    //抽象方法2
    public abstract void abstractMethod2();
}

/**
 * 含钩子方法的具体子类
 */
class HookConcreteClass extends HookAbstractClass {

    @Override
    public void abstractMethod1() {
        System.out.println("抽象方法1的实现被调用...");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("抽象方法2的实现被调用...");
    }

    public void hookMethod1() {
        System.out.println("钩子方法1被重写...");
    }
    public boolean hookMethod2() {
        return false;
    }
}