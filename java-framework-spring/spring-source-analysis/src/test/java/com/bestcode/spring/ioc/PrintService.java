package com.bestcode.spring.ioc;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.30
 */
public class PrintService {

    private UserService userService;

    public void pint(String text) {
        System.out.println("userService: " + userService);
        System.out.println(text);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
