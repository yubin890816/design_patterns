package com.yubin.design.visitor.instance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 利用“访问者（Visitor）模式”模拟艺术公司与造币公司的功能
 *
 * @author YUBIN
 * @create 2020-12-13
 */
public class VisitorProducer {

    public static void main(String[] args) {
        SetMaterial os = new SetMaterial();
        os.add(new Paper());
        os.add(new Cuprum());
        Company visitor = new ArtCompany();
        String result1 = os.accept(visitor);
        System.out.println("艺术公司: " + result1);
        System.out.println("------------------------");
        visitor = new Mint();
        String result2 = os.accept(visitor);
        System.out.println("造币公司: " + result2);
    }
}


/**
 * 抽象访问者:公司
 */
interface Company {
    String create(Paper element);

    String create(Cuprum element);
}

//具体访问者：艺术公司
class ArtCompany implements Company {
    public String create(Paper element) {
        return "将纸造成讲学图";
    }
    public String create(Cuprum element) {
        return "将铜造成朱熹铜像";
    }
}

//具体访问者：造币公司
class Mint implements Company {
    public String create(Paper element) {
        return "将纸造成纸币";
    }
    public String create(Cuprum element) {
        return "将铜造成铜币";
    }
}

//抽象元素：材料
interface Material {
    String accept(Company visitor);
}

//具体元素：纸
class Paper implements Material {
    public String accept(Company visitor) {
        return (visitor.create(this));
    }
}
//具体元素：铜
class Cuprum implements Material {
    public String accept(Company visitor) {
        return (visitor.create(this));
    }
}

/**
 * 对象结构角色: 材料集
 */
class SetMaterial {
    private List<Material> list = new ArrayList<Material>();

    public String accept(Company visitor) {
        Iterator<Material> i = list.iterator();
        String tmp = "";
        for (Material material : list) {
            tmp += material.accept(visitor) + " ";
        }
        return tmp; // 返回某公司的作品集
    }

    public void add(Material element) {
        list.add(element);
    }

    public void remove(Material element) {
        list.remove(element);
    }
}