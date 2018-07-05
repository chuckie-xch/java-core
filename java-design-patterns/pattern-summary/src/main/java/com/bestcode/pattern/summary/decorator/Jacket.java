package com.bestcode.pattern.summary.decorator;

/**
 * 具体装饰者夹克
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public class Jacket extends ClothesDecorator {

    public Jacket(Person person) {
        super(person);
    }

    @Override
    public Double cost() {
        return person.cost() + 100;
    }

    @Override
    public void show() {
        System.out.println("穿上夹克，累计消费：" + cost());
    }
}
