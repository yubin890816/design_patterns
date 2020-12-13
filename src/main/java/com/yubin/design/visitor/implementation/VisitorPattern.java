package com.yubin.design.visitor.implementation;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式的实现
 *
 * @author YUBIN
 * @create 2020-12-13
 */
public class VisitorPattern {

    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();
        os.add(new ConcreteElementA());
        os.add(new ConcreteElementB());
        Visitor visitor = new ConcreteVisitorA();
        os.accept(visitor);
        System.out.println("------------------------");
        visitor = new ConcreteVisitorB();
        os.accept(visitor);
    }
}

/**
 * 抽象访问者角色：定义一个访问具体元素的接口，为每个具体元素类对应一个访问操作visit(),该操作中的参数类型识别了被访问的具体元素
 */
interface Visitor {

    public void visit(ConcreteElementA element);

    public void visit(ConcreteElementB element);
}

/**
 * 具体访问者角色A: 实现抽象访问者角色中声明的各个访问操作，确定访问者访问一个元素时该做什么。
 */
class ConcreteVisitorA implements Visitor {

    @Override
    public void visit(ConcreteElementA element) {
        // 每个visitor可以对
        System.out.println("具体访问者A访问-->" + element.operationA());
    }

    @Override
    public void visit(ConcreteElementB element) {
        System.out.println("具体访问者A访问-->" + element.operationB());
    }
}

/**
 * 具体访问者角色B
 */
class ConcreteVisitorB implements Visitor {

    @Override
    public void visit(ConcreteElementA element) {
        System.out.println("具体访问者B访问-->" + element.operationA());
    }

    @Override
    public void visit(ConcreteElementB element) {
        System.out.println("具体访问者A访问-->" + element.operationB());
    }
}

/**
 * 抽象元素角色: 声明一个包含接受操作 accept() 的接口，被接受的访问者对象作为 accept() 方法的参数。
 */
interface Element {

    public void accept(Visitor visitor);
}

/**
 * 具体元素角色A: 实现抽象元素角色提供的 accept() 操作，其方法体通常都是 visitor.visit(this) ，另外具体元素中可能还包含本身业务逻辑的相关操作。
 */
class ConcreteElementA implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationA() {
        return "操作具体元素A";
    }
}

/**
 * 具体元素角色B
 */
class ConcreteElementB implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationB() {
        return "操作具体元素B";
    }
}

/**
 * 对象结构角色: 是一个包含元素角色的容器，提供让访问者对象遍历容器中的所有元素的方法，通常由 List、Set、Map 等聚合类实现。
 */
class ObjectStructure {

    private List<Element> list;

    public ObjectStructure() {
        this.list = new ArrayList<>();
    }

    public void accept(Visitor visitor) {
        for (Element element : list) {
            element.accept(visitor);
        }
    }

    public void add(Element element) {
        list.add(element);
    }

    public void remove(Element element) {
        list.remove(element);
    }
}