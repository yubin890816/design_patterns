package com.yubin.design.design_principle.ocp.before;

/**
 * 图表显示类
 *
 * @author YUBIN
 * @create 2020-12-08
 */
public class ChartDisplay {

    public void display(String type) {
        if (type.equals("pie")) {
            PieChart chart = new PieChart();
            chart.display();
        } else if (type.equals("bar")) {
            BarChart chart = new BarChart();
            chart.display();
        }
    }
}
