package com.bestcode.security.core;

import java.io.Serializable;

/**
 * 授予的权限
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.14
 */
public interface GrantedAuthority extends Serializable{

    String getAuthority();
}
