package com.bestcode.spring.ioc;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.30
 */
public class UserServiceImpl implements UserService {

    private String text;

    private PrintService printService;

    public void helloWorld() {
        printService.pint(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPrintService(PrintService printService) {
        this.printService = printService;
    }
}
