package com.yubin.design.chain_of_responsibility.implementation;

/**
 * 客户端类
 *
 * @author YUBIN
 * @create 2020-12-12
 */
public class Client {

    public static void main(String[] args) {
        // 组装责任链
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);

        // 提交请求
        handler1.handleRequest("two");
    }
}
