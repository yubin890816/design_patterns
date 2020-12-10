package com.yubin.design.strategy;

/**
 * 做乘法的策略
 *
 * @author YUBIN
 * @create 2020-12-10
 */
public class OperationMultiplication implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
