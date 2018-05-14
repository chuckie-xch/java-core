package com.bestcode.security.core.context;

/**
 * 安全上下文存储策略接口
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.14
 */
public interface SecurityContextHolderStrategy {

    SecurityContext getContext();

    void setContext(SecurityContext securityContext);
}
