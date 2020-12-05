package com.yubin.strategy;

import java.util.Comparator;

/**
 * 按照猫的体重从小到大排序
 *
 * @author YUBIN
 * @create 2020-12-06
 */
public class CatWeightComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.weight > o2.weight) {
            return 1;
        }
        if (o1.weight < o2.weight) {
            return -1;
        }
        return 0;
    }
}
