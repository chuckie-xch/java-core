package com.bestcode.security.core.context;

import com.bestcode.security.core.Authentication;

/**
 * SecurityContext接口实现
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.14
 */
public class SecurityContextImpl implements SecurityContext{

    private Authentication authentication;

    public Authentication getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }
}
