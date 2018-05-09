package com.bestcode.javacore.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ArrayList demo
 * 1.扩容原理
 * 2.如何防溢出
 *
 * @author xch
 * @create 2018-04-11 23:01
 **/
public class ArrayListExample {

    public static void main(String[] args) {
        int[] array = {3, 5, 2, 9};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        List<Integer> list = Arrays.asList(3,5,2,9);
        Collections.sort(list);
        System.out.println(list);
    }
}
