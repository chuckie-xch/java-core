package com.bestcode.security.core.context;

import com.bestcode.security.core.Authentication;

/**
 * 安全上下文信息
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.14
 */
public interface SecurityContext {

    Authentication getAuthentication();

    void setAuthentication(Authentication authentication);
}
