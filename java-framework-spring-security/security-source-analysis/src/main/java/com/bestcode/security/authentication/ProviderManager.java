package com.bestcode.security.authentication;

import com.bestcode.security.core.Authentication;
import com.bestcode.security.core.AuthenticationException;

/**
 * 实现了AuthenticationManager接口，内部维护一个AuthenticationProvider列表，委托provider调用authenticate方法进行认证
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.15
 */
public class ProviderManager implements AuthenticationManager{

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }
}
