package com.bestcode.security.authentication.encoding;

/**
 * 密码加密接口
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.15
 */
public interface PasswordEncoder {

    String encodePassword(String rawPassword, Object salt);

    boolean isPasswordValid(String encPassword, String rawPassword, Object salt);
}
