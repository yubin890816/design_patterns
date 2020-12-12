package com.yubin.design.observer.implementation;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者(Observer)模式测试类
 *
 * @author YUBIN
 * @create 2020-12-12
 */
public class ObserverTest {

    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        subject.add(new ConcreteObserver1());
        subject.add(new ConcreteObserver2());
        subject.notifyObserver();
    }
}

/**
 * 抽象主题(Subject)角色
 */
abstract class Subject {
    // 存放观察者对象的容器
    protected List<Observer> observerList = new ArrayList<>();

    // 增加观察者对象的方法
    public void add(Observer observer) {
        observerList.add(observer);
    }

    // 删除观察者对象的方法
    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    // 通知所有观察者的抽象方法
    public abstract void notifyObserver();
}

/**
 * 具体主题(Concrete Subject)角色
 */
class ConcreteSubject extends Subject {

    @Override
    public void notifyObserver() {
        System.out.println("具体目标发送变化,通知所有观察者更新自身状态");
        for (Observer observer : observerList) {
            observer.response();
        }
    }
}

/**
 * 抽象观察者(Observer)角色
 */
interface Observer {

    // 响应具体目标发生变化时更新自身状态
    public void response();
}

/**
 * 具体观察者(Observer)角色1
 */
class ConcreteObserver1 implements Observer {

    @Override
    public void response() {
        System.out.println("具体观察者(Observer)角色1接收到具体主题发生的变化,并更新了自身状态");
    }
}

/**
 * 具体观察者(Observer)角色2
 */
class ConcreteObserver2 implements Observer {

    @Override
    public void response() {
        System.out.println("具体观察者(Observer)角色2接收到具体主题发生的变化,并更新了自身状态");
    }
}