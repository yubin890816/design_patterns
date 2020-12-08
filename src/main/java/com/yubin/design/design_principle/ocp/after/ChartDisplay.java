package com.yubin.design.design_principle.ocp.after;

/**
 * 图表显示类
 *
 * @author YUBIN
 * @create 2020-12-08
 */
public class ChartDisplay {

    private AbstractChart chart;

    public void setChart(AbstractChart chart) {
        this.chart = chart;
    }

    public void display() {
        chart.display();
    }
}
