package com.bestcode.security.authentication;

import com.bestcode.security.core.Authentication;
import com.bestcode.security.core.GrantedAuthority;
import com.bestcode.security.core.userdetails.UserDetails;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 抽象Authentication基类
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.15
 */
public abstract class  AbstractAuthenticationToken implements Authentication{

    private final Collection<GrantedAuthority> authorities;
    private Object details;

    public AbstractAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
        if (authorities == null) {
            this.authorities = AuthorityUtils.NO_AUTHORITIES;
            return ;
        }
        for (GrantedAuthority authority: authorities) {
            if (authority == null) {
                throw new IllegalArgumentException("Authorities不能包含null值");
            }
        }
        List<GrantedAuthority> tmp = new ArrayList<GrantedAuthority>(authorities.size());
        tmp.addAll(authorities);
        this.authorities = Collections.unmodifiableList(tmp);
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }

    public String getName() {
        if (getPrincipal() instanceof UserDetails) {
           return ((UserDetails ) getPrincipal()).getUsername();
        }
        if (getPrincipal() instanceof Principal) {
            return ((Principal) getPrincipal()).getName();
        }
        return getPrincipal() == null ? "" : getPrincipal().toString();
    }
}
