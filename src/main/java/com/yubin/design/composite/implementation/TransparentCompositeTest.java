package com.yubin.design.composite.implementation;

import java.util.ArrayList;
import java.util.List;

/**
 * 透明式的组合模式实现
 *
 * @author YUBIN
 * @create 2020-12-13
 */
public class TransparentCompositeTest {

    public static void main(String[] args) {
        // 根节点
        Component c0 = new Composite();
        // 树枝节点
        Component c1 = new Composite();

        // c0的树叶节点
        Component leaf1 = new Leaf("leaf1");
        // c1的树叶节点
        Component leaf2 = new Leaf("leaf2");
        // c1的树叶节点
        Component leaf3 = new Leaf("leaf3");
        c0.add(leaf1);
        c0.add(c1);
        c1.add(leaf2);
        c1.add(leaf3);
        c0.operation();
    }
}

/**
 * 抽象构件
 */
interface Component {

    public void add(Component c);

    public void remove(Component c);

    public Component getChild(int i);

    public void operation();
}

/**
 * 树叶构件
 */
class Leaf implements Component {

    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void add(Component c) {

    }

    @Override
    public void remove(Component c) {

    }

    @Override
    public Component getChild(int i) {
        return null;
    }

    @Override
    public void operation() {
        System.out.println("树叶" + name + ":被访问!");
    }
}

/**
 * 树枝构建
 */
class Composite implements Component {

    private List<Component> childrenList = null;

    public Composite() {
        childrenList = new ArrayList<>();
    }

    @Override
    public void add(Component c) {
        childrenList.add(c);
    }

    @Override
    public void remove(Component c) {
        childrenList.remove(c);
    }

    @Override
    public Component getChild(int i) {
        return childrenList.get(i);
    }

    @Override
    public void operation() {
        for (Component component : childrenList) {
            component.operation();
        }
    }
}