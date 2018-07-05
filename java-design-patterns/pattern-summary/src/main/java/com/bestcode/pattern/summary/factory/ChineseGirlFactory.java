package com.bestcode.pattern.summary.factory;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public class ChineseGirlFactory extends AbstractGirlFactory {
    @Override
    Girl createGirl(String whatYouLike) {
        Girl girl = null;
        if ("longhair".equals(whatYouLike)) {
            girl = new LongHairGirl();
        }
        return girl;
    }
}
