package com.yubin.design.singleton;

import java.io.*;

/**
 * 如何破坏一个单例-序列化攻击
 *
 * @author YUBIN
 * @create 2020-12-09
 */
public class SingletonAttack02 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serializationAttack();
    }

    public static void serializationAttack() throws IOException, ClassNotFoundException {
        // 对象序列化流去对对象进行操作
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("serFile"));
        // 通过单例代码获取一个实例
        //Singleton03 instance1 = Singleton03.getInstance();
        Singleton04 instance1 = Singleton04.INSTANCE;

        // 将单例对象,通过序列化流,序列化到文件中
        outputStream.writeObject(instance1);
        // 通过序列化流,将文件中序列化的对象信息读取到内存中
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("serFile")));

        // 通过序列化流去创建对象
        Singleton04 instance2 = (Singleton04) inputStream.readObject();
        System.out.println(instance1 == instance2);
    }
}

