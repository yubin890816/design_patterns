package com.yubin.design.prototype;

import java.io.*;

/**
 * 原型模式-原型类
 *
 * @author YUBIN
 * @create 2020-12-09
 */
public class Prototype implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    private String string;

    private SerializableObject obj;

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

    public SerializableObject getObj() {
        return obj;
    }

    public void setObj(SerializableObject obj) {
        this.obj = obj;
    }

    private class SerializableObject implements Serializable {
        private static final long serialVersionUID = 1L;
    }
}

