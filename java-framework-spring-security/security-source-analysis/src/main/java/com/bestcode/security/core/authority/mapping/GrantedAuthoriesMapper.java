package com.bestcode.security.core.authority.mapping;

import com.bestcode.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.15
 */
public interface GrantedAuthoriesMapper {

    Collection<? extends GrantedAuthority> mapAuthorities(Collection<? extends GrantedAuthority> authorities);
}
