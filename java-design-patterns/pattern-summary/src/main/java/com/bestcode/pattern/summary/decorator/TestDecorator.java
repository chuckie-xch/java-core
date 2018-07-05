package com.bestcode.pattern.summary.decorator;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public class TestDecorator {

    public static void main(String[] args) {
        Person laoWang = new LaoWang();
        // 穿上夹克
        laoWang = new Jacket(laoWang);
        laoWang.show();
        // 戴上帽子
        laoWang = new Hat(laoWang);
        laoWang.show();
        System.out.println("买单，共消费：" + laoWang.cost());
    }
}
