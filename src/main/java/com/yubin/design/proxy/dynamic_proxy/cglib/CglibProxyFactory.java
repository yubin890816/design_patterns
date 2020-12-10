package com.yubin.design.proxy.dynamic_proxy.cglib;

import com.yubin.design.proxy.dynamic_proxy.Dog;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态代理
 *
 * @author YUBIN
 * @create 2020-12-10
 */
public class CglibProxyFactory implements MethodInterceptor {

    public Object getProxy(Class clazz) {
        // 创建增强器
        Enhancer enhancer = new Enhancer();
        // 设置需要增强的类的类对象
        enhancer.setSuperclass(clazz);
        // 设置回调函数
        enhancer.setCallback(this);
        // 获取增强之后的代理对象
        return enhancer.create();
    }

    /**
     * @param proxy       代理对象(被代理对象的子类)
     * @param method      被代理对象的方法
     * @param args        被代理对象的方法参数列表
     * @param proxyMethod 代理对象的方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy proxyMethod) throws Throwable {
        System.out.println("before proxy");
        // 通过调用子类[代理类]的invokeSupper方法，实际调用的是[目标对象]的方法
        Object result = proxyMethod.invokeSuper(proxy, args);
        System.out.println("after proxy");
        return result;
    }

    public static void main(String[] args) {
        CglibProxyFactory proxyFactory = new CglibProxyFactory();
        Dog proxy = (Dog) proxyFactory.getProxy(Dog.class);
        proxy.eat("粑粑");
    }
}
