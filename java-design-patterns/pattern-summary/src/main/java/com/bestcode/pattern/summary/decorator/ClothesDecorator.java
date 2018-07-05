package com.bestcode.pattern.summary.decorator;

/**
 * 装饰器超类，和被装饰对象实现相同的接口
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public abstract class ClothesDecorator implements Person{

    protected Person person;

    public ClothesDecorator(Person person) {
        this.person = person;
    }
}
