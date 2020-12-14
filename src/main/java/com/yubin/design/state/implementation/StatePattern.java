package com.yubin.design.state.implementation;

/**
 * 状态模式
 *
 * @author YUBIN
 * @create 2020-12-14
 */
public class StatePattern {

    public static void main(String[] args) {
        // 创建环境
        Context context = new Context();
        // 处理请求
        context.handle();
        context.handle();
        context.handle();
        context.handle();
    }
}

/**
 * 环境类
 */
class Context {
    private State state;

    public Context() {
        state = new ConcreteStateA();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void handle() {
        state.handle(this);
    }
}

/**
 * 抽象状态类
 */
interface State {
    public void handle(Context context);
}

/**
 * 具体状态A
 */
class ConcreteStateA implements State {

    @Override
    public void handle(Context context) {
        System.out.println("当前状态是 A.");
        context.setState(new ConcreteStateB());
    }
}

/**
 * 具体状态B
 */
class ConcreteStateB implements State {

    @Override
    public void handle(Context context) {
        System.out.println("当前状态是 B.");
        context.setState(new ConcreteStateA());
    }
}