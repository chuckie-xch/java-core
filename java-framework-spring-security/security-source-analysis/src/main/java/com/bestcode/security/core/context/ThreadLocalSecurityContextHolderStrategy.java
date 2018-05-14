package com.bestcode.security.core.context;

/**
 * 基于ThreadLocal策略的安全上下文存储
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.14
 */
final class ThreadLocalSecurityContextHolderStrategy implements SecurityContextHolderStrategy {

    private static final ThreadLocal<SecurityContext> contextHolder = new ThreadLocal<SecurityContext>();

    public SecurityContext getContext() {
        SecurityContext ctx = contextHolder.get();
        if (ctx == null) {
            ctx = createEmptyContext();
            contextHolder.set(ctx);
        }
        return ctx;
    }

    public void setContext(SecurityContext securityContext) {
        contextHolder.set(securityContext);
    }

    public SecurityContext createEmptyContext() {
        return new SecurityContextImpl();
    }
}
