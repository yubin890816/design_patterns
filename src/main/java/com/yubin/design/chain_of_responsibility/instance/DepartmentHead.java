package com.yubin.design.chain_of_responsibility.instance;

/**
 * 具体的处理者-系主任
 *
 * @author YUBIN
 * @create 2020-12-12
 */
public class DepartmentHead extends Leader {
    @Override
    public void handleRequest(int leaveDays) {
        if (leaveDays <= 7) {
            System.out.println("系主任批准您请假" + leaveDays + "天");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(leaveDays);
            } else {
                System.out.println("请假天数太多，没有人批准该假条！");
            }
        }
    }
}
