package com.bestcode.security.core.userdetails;

/**
 * 被UserDetailsService调用，用来检查加载的UserDetails对象的状态或信息
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.15
 */
public interface UserDetailsChecker {

    void check(UserDetails toCheck);
}
