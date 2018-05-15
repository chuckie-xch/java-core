package com.bestcode.security.core.userdetails;

import com.bestcode.security.core.AuthenticationException;

/**
 * 未找到该用户异常
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.15
 */
public class UsernameNotFoundException extends AuthenticationException {

    public UsernameNotFoundException(String message) {
        super(message);
    }

    public UsernameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
