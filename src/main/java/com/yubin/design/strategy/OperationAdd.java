package com.yubin.design.strategy;

/**
 * 做加法的策略
 *
 * @author YUBIN
 * @create 2020-12-10
 */
public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
