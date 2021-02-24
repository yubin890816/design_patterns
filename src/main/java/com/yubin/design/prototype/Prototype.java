package com.yubin.design.prototype;

import java.io.*;
import java.util.Date;

/**
 * 原型模式-原型类
 *
 * @author YUBIN
 * @create 2020-12-09
 */
public class Prototype implements Cloneable, Serializable {
    //private static final long serialVersionUID = 1L;

    private String string;

    private Date date;

    public Prototype(String string, Date date) {
        this.string = string;
        this.date = date;
    }

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Prototype prototype1 = new Prototype("张三", new Date());
        Object prototype2 = prototype1.clone();
        Object prototype3 = prototype1.deepClone();
        System.out.println(prototype1 == prototype2);
        System.out.println(prototype1 == prototype3);
    }

    // 浅复制
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Prototype prototype = (Prototype) super.clone();
        return prototype;
    }

    // 深复制
    public Object deepClone() throws IOException, ClassNotFoundException {
        // 写入当前对象的二进制流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        // 读出二进制流产生的新对象
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

