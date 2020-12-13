package com.yubin.design.composite.instance;

import java.util.ArrayList;
import java.util.List;

/**
 * "天街e角"店购物测试类
 *
 * @author YUBIN
 * @create 2020-12-13
 */
public class ShoppingTest {

    public static void main(String[] args) {
        // 总价格
        float s = 0;
        // 树枝节点
        Bags bigBag = new Bags("大袋子");
        Bags mediumBag = new Bags("中袋子");
        Bags smallRedBag = new Bags("红色小袋子");
        Bags smallWhiteBag = new Bags("白色小袋子");
        // 树叶节点
        Goods sp1 = new Goods("婺源特产", 2, 7.9f);
        smallRedBag.add(sp1);

        Goods sp2 = new Goods("婺源地图", 1, 9.9f);
        smallRedBag.add(sp2);

        Goods sp3 = new Goods("景德镇瓷器", 1, 380);
        mediumBag.add(sp3);
        mediumBag.add(smallRedBag);

        Goods sp4 = new Goods("韶关香菇", 2, 68);
        smallWhiteBag.add(sp4);

        Goods sp5 = new Goods("韶关红茶", 3, 180);
        smallWhiteBag.add(sp5);

        Goods sp6 = new Goods("李宁牌运动鞋", 1, 198);

        bigBag.add(sp6);
        bigBag.add(smallWhiteBag);
        bigBag.add(mediumBag);
        System.out.println("您选购的商品有：");
        bigBag.show();
        s = bigBag.calculation();
        System.out.println("");
        System.out.println("要支付的总价是：" + s + "元");
    }
}

/**
 * 抽象构建 物品:提供计算价格和显示所有商品信息
 */
interface Articles {

    // 计算商品价格的方法
    public float calculation();

    // 显示所有商品信息的方法
    public void show();
}

/**
 * 树叶构件 商品
 */
class Goods implements Articles {

    private String name; // 商品的名称

    private int quantity; // 商品的数量

    private float unitPrice; // 商品的单价

    public Goods(String name, int quantity, float unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    @Override
    public float calculation() {
        return quantity * unitPrice;
    }

    @Override
    public void show() {
        System.out.println(name + "(数量：" + quantity + "，单价：" + unitPrice + "元)");
    }
}

/**
 * 树枝构件 袋子
 */
class Bags implements Articles {

    private String name; // 袋子的名字

    private List<Articles> articlesList; // 袋子里面放的物品

    public Bags(String name) {
        this.name = name;
        articlesList = new ArrayList<>();
    }

    // 往袋子里放入商品
    public void add(Articles articles) {
        articlesList.add(articles);
    }

    // 从袋子里移除商品
    public void remove(Articles articles) {
        articlesList.remove(articles);
    }

    // 查看袋子里的指定商品信息
    public Articles getChild(int i) {
        return articlesList.get(i);
    }

    @Override
    public float calculation() {
        float s = 0;
        for (Articles articles : articlesList) {
            s += articles.calculation();
        }
        return s;
    }

    @Override
    public void show() {
        for (Articles articles : articlesList) {
            articles.show();
        }
    }
}