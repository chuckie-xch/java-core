package com.bestcode.security.core.userdetails;

import com.bestcode.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

/**
 * 存储用户信息
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.15
 */
public interface UserDetails extends Serializable{

    Collection<? extends GrantedAuthority> getAuthorities();

    String getUsername();

    String getPassword();

    boolean isEnabled();

    boolean isAccountNonExpired();
}
