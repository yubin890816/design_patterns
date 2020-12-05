package com.yubin.strategy;

import java.util.Arrays;

/**
 * 测试类
 *
 * @author YUBIN
 * @create 2020-12-06
 */
public class Main {

    public static void main(String[] args) {
        //int[] a = {9, 5, 8, 3, 2, 6, 7, 1, 4};
        Cat[] a = {new Cat(3, 3), new Cat(1, 1), new Cat(5, 5)};
        Sorter sorter = new Sorter();
        sorter.sort(a, new CatWeightComparator());
        System.out.println(Arrays.toString(a));
        sorter.sort(a, new CatHeightComparator());
        System.out.println(Arrays.toString(a));
    }
}
