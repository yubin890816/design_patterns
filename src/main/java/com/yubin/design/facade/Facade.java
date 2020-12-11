package com.yubin.design.facade;

/**
 * 门面类
 *
 * @author YUBIN
 * @create 2020-12-11
 */
public class Facade {

    private SubSystemA systemA;

    private SubSystemB systemB;

    private SubSystemC systemC;

    public Facade() {
        systemA = new SubSystemA();
        systemB = new SubSystemB();
        systemC = new SubSystemC();
    }

    public void methodA() {
        systemA.operationA();
    }

    public void methodB() {
        systemB.operationB();
    }

    public void methodC() {
        systemC.operationC();
    }
}
