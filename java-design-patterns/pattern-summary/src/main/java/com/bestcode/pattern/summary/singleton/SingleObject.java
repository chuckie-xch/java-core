package com.bestcode.pattern.summary.singleton;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.05
 */
public class SingleObject {

//    private volatile static SingleObject instance;
////
////    private SingleObject() {}
////
////    public static SingleObject getInstance() {
////        if (instance == null) {
////            synchronized (SingleObject.class) {
////                if (instance == null) {
////                    instance = new SingleObject();
////                }
////            }
////        }
////        return instance;
////    }


    private volatile static SingleObject instance;

    private SingleObject() {}

    public static SingleObject getInstance() {
        if (instance == null) {
            synchronized (SingleObject.class) {
                if (instance == null) {
                    instance = new SingleObject();
                }
            }
        }
        return instance;
    }
}
