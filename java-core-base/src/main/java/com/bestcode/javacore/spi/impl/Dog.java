package com.bestcode.javacore.spi.impl;

import com.bestcode.javacore.spi.Animal;

/**
 * @author xch
 * @create 2018-05-21 0:16
 **/
public class Dog implements Animal {

    @Override
    public void say() {
        System.out.println("this is a dog");
    }
}
