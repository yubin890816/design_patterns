package com.yubin.design.command.instance;

/**
 * 用命令模式实现客户去餐馆吃早餐的实例。
 *
 * @author YUBIN
 * @create 2020-12-13
 */
public class CookingCommand {
    public static void main(String[] args) {
        Breakfast food1 = new ChangFen();
        Breakfast food2 = new HunTun();
        Breakfast food3 = new HeFen();
        Waiter fwy = new Waiter();
        fwy.setChangFen(food1);//设置肠粉菜单
        fwy.setHunTun(food2);  //设置河粉菜单
        fwy.setHeFen(food3);   //设置馄饨菜单
        fwy.chooseChangFen();  //选择肠粉
        fwy.chooseHeFen();     //选择河粉
        fwy.chooseHunTun();    //选择馄饨
    }
}

/**
 * 抽象命令类: 早餐类
 */
interface Breakfast {
    public void cooking();
}

/**
 * 具体命令类: 肠粉
 */
class ChangFen implements Breakfast {

    private ChangFenChef receiver;

    public ChangFen() {
        receiver = new ChangFenChef();
    }

    @Override
    public void cooking() {
        receiver.cooking();
    }
}

/**
 * 具体命令类: 馄饨
 */
class HunTun implements Breakfast {

    private HunTunChef receiver;

    public HunTun() {
        this.receiver = new HunTunChef();
    }

    @Override
    public void cooking() {
        receiver.cooking();
    }
}

/**
 * 具体命令类: 河粉
 */
class HeFen implements Breakfast {

    private HeFenChef receiver;

    public HeFen() {
        receiver = new HeFenChef();
    }

    @Override
    public void cooking() {
        receiver.cooking();
    }
}

/**
 * 命令接收者: 肠粉厨师
 */
class ChangFenChef {

    public void cooking() {
        System.out.println("肠粉厨师做了一份肠粉...");
    }
}

/**
 * 命令接收者: 馄饨厨师
 */
class HunTunChef {

    public void cooking() {
        System.out.println("馄饨厨师做了一份馄饨...");
    }
}

/**
 * 命令接收者: 河粉厨师
 */
class HeFenChef {

    public void cooking() {
        System.out.println("河粉厨师做了一份河粉...");
    }
}

/**
 * 调用者: 服务员
 */
class Waiter {
    private Breakfast changFen, hunTun, heFen;

    public void setChangFen(Breakfast f) {
        changFen = f;
    }
    public void setHunTun(Breakfast f) {
        hunTun = f;
    }
    public void setHeFen(Breakfast f) {
        heFen = f;
    }

    public void chooseChangFen() {
        changFen.cooking();
    }

    public void chooseHunTun() {
        hunTun.cooking();
    }

    public void chooseHeFen() {
        heFen.cooking();
    }
}