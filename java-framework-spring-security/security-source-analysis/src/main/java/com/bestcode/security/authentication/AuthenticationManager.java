package com.bestcode.security.authentication;

import com.bestcode.security.core.Authentication;
import com.bestcode.security.core.AuthenticationException;

/**
 * 认证的核心接口,通常的实现为ProviderManager,ProviderManger内部维护一个List<AuthenticationProvider>列表
 * 这是常见的委托模式
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.14
 */
public interface AuthenticationManager {

    /**
     * 认证的核心入口方法
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    Authentication authenticate(Authentication authentication) throws AuthenticationException;
}
