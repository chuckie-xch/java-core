package com.bestcode.pattern.summary.strategy;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public class OperationAdd implements Operation {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
