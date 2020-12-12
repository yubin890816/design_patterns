package com.yubin.design.chain_of_responsibility.instance;

/**
 * 领导抽象类
 *
 * @author YUBIN
 * @create 2020-12-12
 */
public abstract class Leader {

    private Leader next;

    public Leader getNext() {
        return next;
    }

    public void setNext(Leader next) {
        this.next = next;
    }

    public abstract void handleRequest(int leaveDays);
}
