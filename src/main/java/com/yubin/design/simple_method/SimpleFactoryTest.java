package com.yubin.design.simple_method;

/**
 * 简单工厂测试类
 *
 * @author YUBIN
 * @create 2021-02-22
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {
        Product product = SimpleFactory.create("A");
        product.show();
    }

    /**
     * 抽象产品
     */
    public interface Product {
        public void show();
    }

    /**
     * 具体产品1
     */
    static class ConcreteProduct1 implements Product {
        @Override
        public void show() {
            System.out.println("创建具体产品1...");
        }
    }

    /**
     * 具体产品2
     */
    static class ConcreteProduct2 implements Product {
        @Override
        public void show() {
            System.out.println("创建具体产品2...");
        }
    }

    /**
     * 简单工厂
     */
    public static class SimpleFactory {
        public static Product create(String type) {
            if ("A".equals(type)) {
                return new ConcreteProduct1();
            }
            if ("B".equals(type)) {
                return new ConcreteProduct1();
            }
            return null;
        }
    }
}


