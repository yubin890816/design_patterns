package com.yubin.design.principle.dip;

/**
 * 依赖倒置原则的测试类
 *
 * @author YUBIN
 * @create 2021-01-31
 */
public class DIPTest {
    public static void main(String[] args) {
        Customer customer = new Customer();
        System.out.println("顾客购买以下商品:");
        customer.shopping(new ShaoGuanShop());
        customer.shopping(new WuYuanShop());
    }
}

/**
 * 商店
 */
interface Shop {
    // 卖
    public String sell();
}

class ShaoGuanShop implements Shop {

    @Override
    public String sell() {
        return "韶关土特产：香菇、木耳……";
    }
}

class WuYuanShop implements Shop {

    @Override
    public String sell() {
        return "婺源土特产：绿茶、酒糟鱼……";
    }
}

class Customer {
    public void shopping(Shop shop) {
        System.out.println(shop.sell());
    }
}