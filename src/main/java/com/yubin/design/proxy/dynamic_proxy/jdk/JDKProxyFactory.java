package com.yubin.design.proxy.dynamic_proxy.jdk;

import com.yubin.design.proxy.dynamic_proxy.Animal;
import com.yubin.design.proxy.dynamic_proxy.Dog;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 *
 * @author YUBIN
 * @create 2020-12-10
 */
public class JDKProxyFactory implements InvocationHandler {

    private Object target;

    public JDKProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        /**
         * 如何生成一个代理类呢？
         *  1、编写源文件
         *  2、编译源文件为class文件
         *  3、将class文件加载的JVM中（ClassLoader）
         *  4、将class文件对应的对象进行实例化（反射）
         *
         * Proxy是JDK中的API类
         *  参数1：目标对象的类加载器
         *  参数2：目标对象的接口
         *  参数3：代理对象的执行处理器
         */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 代理对象会执行的方法
     * @param proxy 代理类实例
     * @param method 目标类被调用的方法对象
     * @param args 目标类被调用的方法参数列表
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before proxy");
        Object result = method.invoke(target, args);
        System.out.println("after proxy");
        return result;
    }

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        JDKProxyFactory proxyFactory = new JDKProxyFactory(new Dog());
        Animal proxy = (Animal) proxyFactory.getProxy();
        proxy.eat("粑粑");
    }
}
