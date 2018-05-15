package com.bestcode.security.authentication;

import com.bestcode.security.core.GrantedAuthority;

import java.util.Collection; /**
 * 基于用户名密码认的证信息
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.15
 */
public class UsernamePasswordAuthenticationToken extends AbstractAuthenticationToken {

    private final Object principal;
    private Object credentials;

    public UsernamePasswordAuthenticationToken(Object principal, Object credentials) {
        super(null);
        this.principal = principal;
        this.credentials = credentials;
    }

    public UsernamePasswordAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
    }

    public Object getPrincipal() {
        return principal;
    }

    public Object getCredentials() {
        return this.credentials;
    }
}
