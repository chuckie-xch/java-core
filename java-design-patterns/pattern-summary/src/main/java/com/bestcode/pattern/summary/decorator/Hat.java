package com.bestcode.pattern.summary.decorator;

/**
 * 具体装饰：帽子
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public class Hat extends ClothesDecorator {
    public Hat(Person person) {
        super(person);
    }

    @Override
    public Double cost() {
        return person.cost() + 50;
    }

    @Override
    public void show() {
        System.out.println("戴上帽子，累计消费：" + this.cost());
    }
}
