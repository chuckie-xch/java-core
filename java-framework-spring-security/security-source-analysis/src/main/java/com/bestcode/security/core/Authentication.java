package com.bestcode.security.core;

import java.io.Serializable;
import java.util.Collection;

/**
 * 认证信息
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.14
 */
public interface Authentication extends Serializable{

    /**
     * 获取权限
     * @return
     */
    Collection<? extends GrantedAuthority> getAuthorities();

    /**
     * 包含一些认证的而外信息，包括ip等
     * @return
     */
    Object getDetails();

    /**
     * 一般是UserDetails
     * @return
     */
    Object getPrincipal();
}
