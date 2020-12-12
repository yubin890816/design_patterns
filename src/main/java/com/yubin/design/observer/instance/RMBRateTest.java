package com.yubin.design.observer.instance;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用观察者模式书写人民币汇率发生改变时对进出口公司产生的影响测试类
 *
 * @author YUBIN
 * @create 2020-12-12
 */
public class RMBRateTest {
    public static void main(String[] args) {
        Rate rate = new RMBRate();
        rate.add(new ImportCompany());
        rate.add(new ExportCompany());
        rate.change(-2);
        rate.change(3);
    }
}

/**
 * 抽象目标类 汇率Rate
 */
abstract class Rate {

    // 存放观察者对象的容器
    protected List<Company> observerList = new ArrayList<>();

    // 添加具体观察者的方法
    public void add(Company observer) {
        observerList.add(observer);
    }

    // 删除具体观察者的方法
    public void remove(Company observer) {
        observerList.remove(observer);
    }

    // 当汇率发生改变时通知进出口公司的抽象方法
    public abstract void change(int number);
}

/**
 * 具体目标类 人民币汇率（RMBrate）
 */
class RMBRate extends Rate {

    @Override
    public void change(int number) {
        for (Company observer : observerList) {
            observer.response(number);
        }
    }
}

/**
 * 抽象观察者 公司(Company)
 */
interface Company {

    public void response(int number);
}

/**
 * 具体观察者1 进口公司
 */
class ImportCompany implements Company {

    @Override
    public void response(int number) {
        if (number > 0) {
            System.out.println("人民币汇率升值" + number + "个基点，降低了进口产品成本，提升了进口公司利润率。");
        } else if (number < 0) {
            System.out.println("人民币汇率贬值" + (-number) + "个基点，提升了进口产品成本，降低了进口公司利润率。");
        }
    }
}

/**
 * 具体观察者2 出口公司
 */
class ExportCompany implements Company {

    @Override
    public void response(int number) {
        if (number > 0) {
            System.out.println("人民币汇率升值" + number + "个基点，降低了出口产品收入，降低了出口公司的销售利润率。");
        } else if (number < 0) {
            System.out.println("人民币汇率贬值" + (-number) + "个基点，提升了出口产品收入，提升了出口公司的销售利润率。");
        }
    }
}