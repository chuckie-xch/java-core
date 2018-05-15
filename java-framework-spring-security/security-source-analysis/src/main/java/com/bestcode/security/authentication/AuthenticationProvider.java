package com.bestcode.security.authentication;

import com.bestcode.security.core.Authentication;
import com.bestcode.security.core.AuthenticationException;

/**
 * 认证的真正服务接口，有多种实现，一般是DaoAuthenticationProvider或者记住我RememberMeAuthenticationProvider
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.15
 */
public interface AuthenticationProvider {

    Authentication authenticate(Authentication authentication) throws AuthenticationException;
}
