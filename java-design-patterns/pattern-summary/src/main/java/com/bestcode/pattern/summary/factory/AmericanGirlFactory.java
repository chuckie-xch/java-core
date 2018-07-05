package com.bestcode.pattern.summary.factory;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public class AmericanGirlFactory extends AbstractGirlFactory {

    @Override
    Girl createGirl(String whatYouLike) {
        Girl girl = null;
        if ("fat".equals(whatYouLike)) {
            girl = new FatGirl();
        } else if ("thin".equals(whatYouLike)) {
            girl = new ThinGirl();
        }
        return girl;
    }
}
