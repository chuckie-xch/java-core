package com.bestcode.security.core.authority.mapping;

import com.bestcode.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 不转换，直接返回authorities
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.15
 */
public class NullAuthoritiesMapper implements GrantedAuthoriesMapper{

    public Collection<? extends GrantedAuthority> mapAuthorities(Collection<? extends GrantedAuthority> authorities) {
        return authorities;
    }
}
