package com.bestcode.pattern.summary.factory;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public class TestFactory {

    public static void main(String[] args) {
        GirlStore girlStore = new GirlStore(new AmericanGirlFactory());
        Girl girl = girlStore.createGirl("thin");
        System.out.println(girl.say());
    }
}
