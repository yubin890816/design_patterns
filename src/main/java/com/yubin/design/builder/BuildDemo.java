package com.yubin.design.builder;

/**
 * 导演类
 *
 * @author YUBIN
 * @create 2020-12-10
 */
public class BuildDemo {

    public static void main(String[] args) {
        StudentBuilder builder = new StudentBuilder();
        Student student = builder.id(1).name("zhangsan").age(18).father("lisi").build();
        System.out.println(student);
    }
}
