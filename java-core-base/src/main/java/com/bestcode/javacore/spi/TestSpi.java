package com.bestcode.javacore.spi;

import java.util.ServiceLoader;

/**
 * @author xch
 * @create 2018-05-21 0:19
 **/
public class TestSpi {

    public static void main(String[] args) {
        ServiceLoader<Animal> animals = ServiceLoader.load(Animal.class);
        for (Animal animal : animals) {
            animal.say();
        }
        Thread thread = new Thread();
        thread.getContextClassLoader();
    }
}
