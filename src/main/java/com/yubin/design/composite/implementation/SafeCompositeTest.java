package com.yubin.design.composite.implementation;

import java.util.ArrayList;
import java.util.List;

/**
 * 透明式的组合模式实现
 *
 * @author YUBIN
 * @create 2020-12-13
 */
public class SafeCompositeTest {

    public static void main(String[] args) {
        // 根节点
        SafeComposite c0 = new SafeComposite();
        // 树枝节点
        SafeComposite c1 = new SafeComposite();

        // c0的树叶节点
        SafeComponent leaf1 = new SafeLeaf("leaf1");
        // c1的树叶节点
        SafeComponent leaf2 = new SafeLeaf("leaf2");
        // c1的树叶节点
        SafeComponent leaf3 = new SafeLeaf("leaf3");
        c0.add(leaf1);
        c0.add(c1);
        c1.add(leaf2);
        c1.add(leaf3);
        c0.operation();
    }
}

/**
 * 抽象构建
 */
interface SafeComponent {
    public void operation();
}

/**
 * 树叶构件
 */
class SafeLeaf implements SafeComponent {

    private String name;

    public SafeLeaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("树叶" + name + ":被访问!");
    }
}

/**
 * 树枝构建
 */
class SafeComposite implements SafeComponent {

    private List<SafeComponent> childrenList = null;

    public SafeComposite() {
        childrenList = new ArrayList<>();
    }

    public void add(SafeComponent c) {
        childrenList.add(c);
    }

    public void remove(SafeComponent c) {
        childrenList.remove(c);
    }

    public SafeComponent getChild(int i) {
        return childrenList.get(i);
    }

    @Override
    public void operation() {
        for (SafeComponent component : childrenList) {
            component.operation();
        }
    }
}