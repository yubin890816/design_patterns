package com.yubin.design.observer.instance;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.List;

/**
 * 铃声事件测试类
 *
 * @author YUBIN
 * @create 2020-12-12
 */
public class BellEventTest {

    public static void main(String[] args) {
        BellEventSource source = new BellEventSource();
        source.addPersonListener(new StuEventListener());
        source.addPersonListener(new TeachEventListener());
        source.ring(true);
        System.out.println("========================");
        source.ring(false);
    }
}

/**
 * 铃声事件类：用于封装事件源及一些与事件相关的参数
 */
class RingEvent extends EventObject {
    // 铃声类型 true:表示上课铃声 false:表示下课铃声
    private boolean sound;

    public RingEvent(Object source, boolean sound) {
        super(source);
        this.sound = sound;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }

    public boolean getSound() {
        return sound;
    }
}

/**
 * 目标类：事件源,铃声
 */
class BellEventSource {
    // 保存监听器对象的容器
    private List<BellEventListener> listenerList; //监听器容器

    public BellEventSource() {
        listenerList = new ArrayList<>();
    }

    // 添加监听对象的方法
    public void addPersonListener(BellEventListener listener) {
        listenerList.add(listener);
    }

    // 事件触发器：敲钟，当铃声sound的值发生变化时，触发事件。
    public void ring(boolean sound) {
        String type = sound ? "上课铃" : "下课铃";
        System.out.println(type + "响!");
        // 这里的this就是事件源(目标类)
        RingEvent event = new RingEvent(this, sound);
        // 通知注册在该事件源上的所有监听器
        notifies(event);
    }

    // 当事件发生时,通知绑定在该事件源上的所有监听器做出反应（调用事件处理方法）
    private void notifies(RingEvent event) {
        for (BellEventListener listener : listenerList) {
            listener.heardBell(event);
        }
    }
}

/**
 * 抽象观察者类：铃声事件监听器
 */
interface BellEventListener extends EventListener {

    void heardBell(RingEvent event);
}

//具体观察者类：老师事件监听器
class TeachEventListener implements BellEventListener {
    public void heardBell(RingEvent e) {
        if (e.getSound()) {
            System.out.println("老师上课了...");
        } else {
            System.out.println("老师下课了...");
        }
    }
}
//具体观察者类：学生事件监听器
class StuEventListener implements BellEventListener {
    public void heardBell(RingEvent e) {
        if (e.getSound()) {
            System.out.println("同学们，上课了...");
        } else {
            System.out.println("同学们，下课了...");
        }
    }
}