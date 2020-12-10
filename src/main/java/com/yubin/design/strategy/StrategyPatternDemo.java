package com.yubin.design.strategy;

/**
 * 策略模式测试类
 *
 * @author YUBIN
 * @create 2020-12-10
 */
public class StrategyPatternDemo {

    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));
        context = new Context(new OperationSubtraction());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));
        context = new Context(new OperationMultiplication());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
