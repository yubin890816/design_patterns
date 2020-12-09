package com.yubin.design.builder;

/**
 * 产品类
 *
 * @author YUBIN
 * @create 2020-12-10
 */
public class Student {

    private int id;

    private String name;

    private int age;

    private Father father;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Father getFather() {
        return father;
    }

    public void setFather(Father facther) {
        this.father = facther;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", father=" + father +
                '}';
    }
}
