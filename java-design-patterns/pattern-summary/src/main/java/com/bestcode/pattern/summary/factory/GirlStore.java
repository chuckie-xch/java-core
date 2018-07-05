package com.bestcode.pattern.summary.factory;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public class GirlStore {

    AbstractGirlFactory factory;

    public GirlStore(AbstractGirlFactory factory) {
        this.factory = factory;
    }

    public Girl createGirl(String whatYouLike) {
        return factory.createGirl(whatYouLike);
    }
}
