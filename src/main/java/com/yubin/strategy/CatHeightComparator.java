package com.yubin.strategy;

import java.util.Comparator;

/**
 * 按照猫的身高从大到小排序
 *
 * @author YUBIN
 * @create 2020-12-06
 */
public class CatHeightComparator implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.height > o2.height) {
            return -1;
        }
        if (o1.height < o2.height) {
            return 1;
        }
        return 0;
    }
}
