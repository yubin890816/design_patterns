package com.yubin.design.iterator.implementation;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式实现
 *
 * @author YUBIN
 * @create 2020-12-13
 */
public class IteratorPattern {

    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("1");
        aggregate.add("2");
        aggregate.add("3");
        aggregate.add("4");
        System.out.print("聚合的内容有：");
        Iterator it = aggregate.getIterator();
        while (it.hasNext()) {
            System.out.print(it.next().toString() + "\t");
        }
        Object first = it.first();
        System.out.println("\nFirst:" + first.toString());
    }
}

/**
 * 抽象聚合
 */
interface Aggregate {
    // 往聚合对象中添加元素
    public void add(Object obj);

    // 从聚合元素中删除元素
    public void remove(Object obj);

    // 获取聚合对象的迭代器
    public Iterator getIterator();
}

/**
 * 具体聚合
 */
class ConcreteAggregate implements Aggregate {

    private List<Object> list = null;

    public ConcreteAggregate() {
        list = new ArrayList<>();
    }

    @Override
    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public void remove(Object obj) {
        list.remove(obj);
    }

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator(list);
    }
}

/**
 * 抽象迭代器
 */
interface Iterator {

    // 获取聚合对象中的第一个元素
    Object first();

    // 获取聚合对象中的下一个元素
    Object next();

    // 判断聚合对象中是否还存在下一个元素
    boolean hasNext();
}

class ConcreteIterator implements Iterator {

    private List<Object> list;
    private int index = -1;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }

    @Override
    public Object first() {
        index = 0;
        return list.get(index);
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            return list.get(++index);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if (index < list.size() - 1) {
            return true;
        }
        return false;
    }
}