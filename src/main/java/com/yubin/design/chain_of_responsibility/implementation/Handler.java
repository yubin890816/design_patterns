package com.yubin.design.chain_of_responsibility.implementation;

/**
 * 抽象处理者
 *
 * @author YUBIN
 * @create 2020-12-12
 */
public abstract class Handler {

    private Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    // 处理请求的方法
    public abstract void handleRequest(String request);
}
