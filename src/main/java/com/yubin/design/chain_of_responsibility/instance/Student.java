package com.yubin.design.chain_of_responsibility.instance;

/**
 * 客户端类-学生
 *
 * @author YUBIN
 * @create 2020-12-12
 */
public class Student {

    public static void main(String[] args) {
        // 组装责任链
        Leader teacher1 = new ClassAdviser();
        Leader teacher2 = new DepartmentHead();
        Leader teacher3 = new Dean();
        //Leader teacher4 = new DeanOfStudies();
        teacher1.setNext(teacher2);
        teacher2.setNext(teacher3);
        //teacher3.setNext(teacher4);

        teacher1.handleRequest(2);
        teacher1.handleRequest(6);
        teacher1.handleRequest(10);
        teacher1.handleRequest(12);
    }
}
