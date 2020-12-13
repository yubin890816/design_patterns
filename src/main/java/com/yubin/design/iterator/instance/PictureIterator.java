package com.yubin.design.iterator.instance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * 景点的迭代器
 *
 * @author YUBIN
 * @create 2020-12-13
 */
public class PictureIterator {
    public static void main(String[] args) {
        new PictureFrame();
    }
}

//相框类
class PictureFrame extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    ViewSpotSet ag; //婺源景点集接口
    ViewSpotIterator it; //婺源景点迭代器接口
    WyViewSpot ob;    //婺源景点类
    PictureFrame() {
        super("中国最美乡村“婺源”的部分风景图");
        this.setResizable(false);
        ag = new WyViewSpotSet();
        ag.add(new WyViewSpot("江湾", "江湾景区是婺源的一个国家5A级旅游景区，景区内有萧江宗祠、永思街、滕家老屋、婺源人家、乡贤园、百工坊等一大批古建筑，精美绝伦，做工精细。"));
        ag.add(new WyViewSpot("李坑", "李坑村是一个以李姓聚居为主的古村落，是国家4A级旅游景区，其建筑风格独特，是著名的徽派建筑，给人一种安静、祥和的感觉。"));
        ag.add(new WyViewSpot("思溪延村", "思溪延村位于婺源县思口镇境内，始建于南宋庆元五年（1199年），当时建村者俞氏以（鱼）思清溪水而名。"));
        ag.add(new WyViewSpot("晓起村", "晓起有“中国茶文化第一村”与“国家级生态示范村”之美誉，村屋多为清代建筑，风格各具特色，村中小巷均铺青石，曲曲折折，回环如棋局。"));
        ag.add(new WyViewSpot("菊径村", "菊径村形状为山环水绕型，小河成大半圆型，绕村庄将近一周，四周为高山环绕，符合中国的八卦“后山前水”设计，当地人称“脸盆村”。"));
        ag.add(new WyViewSpot("篁岭", "篁岭是著名的“晒秋”文化起源地，也是一座距今近六百历史的徽州古村；篁岭属典型山居村落，民居围绕水口呈扇形梯状错落排布。"));
        ag.add(new WyViewSpot("彩虹桥", "彩虹桥是婺源颇有特色的带顶的桥——廊桥，其不仅造型优美，而且它可在雨天里供行人歇脚，其名取自唐诗“两水夹明镜，双桥落彩虹”。"));
        ag.add(new WyViewSpot("卧龙谷", "卧龙谷是国家4A级旅游区，这里飞泉瀑流泄银吐玉、彩池幽潭碧绿清新、山峰岩石挺拔奇巧，活脱脱一幅天然泼墨山水画。"));
        it = ag.getIterator(); //获取婺源景点迭代器
        ob = it.first();
        this.showPicture(ob.getName(), ob.getIntroduce());
    }
    //显示图片
    void showPicture(String Name, String Introduce) {
        Container cp = this.getContentPane();
        JPanel picturePanel = new JPanel();
        JPanel controlPanel = new JPanel();
        String FileName = "/git_project/design_patterns/src/main/resources/iterator/picture/" + Name + ".jpg";
        JLabel lb = new JLabel(Name, new ImageIcon(FileName), JLabel.CENTER);
        JTextArea ta = new JTextArea(Introduce);
        lb.setHorizontalTextPosition(JLabel.CENTER);
        lb.setVerticalTextPosition(JLabel.TOP);
        lb.setFont(new Font("宋体", Font.BOLD, 20));
        ta.setLineWrap(true);
        ta.setEditable(false);
        //ta.setBackground(Color.orange);
        picturePanel.setLayout(new BorderLayout(5, 5));
        picturePanel.add("Center", lb);
        picturePanel.add("South", ta);
        JButton first, last, next, previous;
        first = new JButton("第一张");
        next = new JButton("下一张");
        previous = new JButton("上一张");
        last = new JButton("最末张");
        first.addActionListener(this);
        next.addActionListener(this);
        previous.addActionListener(this);
        last.addActionListener(this);
        controlPanel.add(first);
        controlPanel.add(next);
        controlPanel.add(previous);
        controlPanel.add(last);
        cp.add("Center", picturePanel);
        cp.add("South", controlPanel);
        this.setSize(630, 550);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        String command = arg0.getActionCommand();
        if (command.equals("第一张")) {
            ob = it.first();
            this.showPicture(ob.getName(), ob.getIntroduce());
        } else if (command.equals("下一张")) {
            ob = it.next();
            this.showPicture(ob.getName(), ob.getIntroduce());
        } else if (command.equals("上一张")) {
            ob = it.previous();
            this.showPicture(ob.getName(), ob.getIntroduce());
        } else if (command.equals("最末张")) {
            ob = it.last();
            this.showPicture(ob.getName(), ob.getIntroduce());
        }
    }
}

/**
 * 婺源景点类
 */
class WyViewSpot {

    private String name; // 景点名称

    private String introduce; // 景点简介

    public WyViewSpot(String name, String introduce) {
        this.name = name;
        this.introduce = introduce;
    }

    public String getName() {
        return name;
    }

    public String getIntroduce() {
        return introduce;
    }
}

/**
 * 抽象景点聚集类
 */
interface ViewSpotSet {

    // 往聚集对象中添加元素的方法
    void add(WyViewSpot obj);

    // 从聚集对象中删除元素的方法
    void remove(WyViewSpot obj);

    // 获取迭代器方法
    ViewSpotIterator getIterator();
}

/**
 * 具体的聚集类 婺源景点集
 */
class WyViewSpotSet implements ViewSpotSet {
    List<WyViewSpot> list = new ArrayList<>();


    @Override
    public void add(WyViewSpot obj) {
        list.add(obj);
    }

    @Override
    public void remove(WyViewSpot obj) {
        list.remove(obj);
    }

    @Override
    public ViewSpotIterator getIterator() {
        return new WyViewSpotIterator(list);
    }
}

/**
 * 婺源景点的抽象迭代器
 */
interface ViewSpotIterator {
    // 判断聚集对象中是否存在下一个元素
    boolean hasNext();

    // 返回聚集对象中的第一个元素
    WyViewSpot first();

    // 返回聚集对象中的下一个元素
    WyViewSpot next();

    // 返回聚集对象中的前一个元素
    WyViewSpot previous();

    // 返回聚集对象中的最后一个元素
    WyViewSpot last();
}

class WyViewSpotIterator implements ViewSpotIterator {

    List<WyViewSpot> list;

    int index = -1;

    public WyViewSpotIterator(List<WyViewSpot> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (index < list.size() - 1) {
            return true;
        }
        return false;
    }

    @Override
    public WyViewSpot first() {
        index = 0;
        return list.get(index);
    }

    @Override
    public WyViewSpot next() {
        if (this.hasNext()) {
            return list.get(++index);
        }
        return null;
    }

    @Override
    public WyViewSpot previous() {
        if (index > 0) {
            return list.get(--index);
        }
        return null;
    }

    @Override
    public WyViewSpot last() {
        index = list.size() - 1;
        return list.get(index);
    }
}