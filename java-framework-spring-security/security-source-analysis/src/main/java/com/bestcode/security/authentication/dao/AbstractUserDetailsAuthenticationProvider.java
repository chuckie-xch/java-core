package com.bestcode.security.authentication.dao;

import com.bestcode.security.authentication.AuthenticationProvider;
import com.bestcode.security.authentication.AuthorityUtils;
import com.bestcode.security.authentication.UsernamePasswordAuthenticationToken;
import com.bestcode.security.core.Authentication;
import com.bestcode.security.core.AuthenticationException;
import com.bestcode.security.core.GrantedAuthority;
import com.bestcode.security.core.authority.mapping.GrantedAuthoriesMapper;
import com.bestcode.security.core.authority.mapping.NullAuthoritiesMapper;
import com.bestcode.security.core.userdetails.UserCache;
import com.bestcode.security.core.userdetails.UserDetails;
import com.bestcode.security.core.userdetails.UserDetailsChecker;
import com.bestcode.security.core.userdetails.cache.NullUserCache;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 认证抽象类
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.15
 */
public abstract class AbstractUserDetailsAuthenticationProvider implements AuthenticationProvider {

    private UserCache userCache = new NullUserCache();
    private UserDetailsChecker preAuthenticationChecks = new DefaultPreAuthenticationChecks();
    private UserDetailsChecker postAuthenticationChecks = new DefaultPostAuthenticationChecks();
    private boolean forcePrincipalAsString = false;
    private GrantedAuthoriesMapper authoriesMapper = new NullAuthoritiesMapper();


    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal() == null ? "NONE_PROVIDED" : authentication.getName();
        boolean cacheWasUsed = true;
        UserDetails user = userCache.getUserFromCache(username);
        if (user == null) {
            cacheWasUsed = false;
            user = retrieveUser(username, (UsernamePasswordAuthenticationToken) authentication);
            Assert.notNull(user, "retrieveUser returned null");
        }
        try {
            preAuthenticationChecks.check(user);
            additionalAuthenticationChecks(user, (UsernamePasswordAuthenticationToken) authentication);
        } catch (AuthenticationException exception) {
            if (cacheWasUsed) {
                cacheWasUsed = false;
                user = user = retrieveUser(username, (UsernamePasswordAuthenticationToken) authentication);
                preAuthenticationChecks.check(user);
                additionalAuthenticationChecks(user, (UsernamePasswordAuthenticationToken) authentication);
            } else {
                throw exception;
            }
        }
        postAuthenticationChecks.check(user);
        if (!cacheWasUsed) {
            this.userCache.putUserInCache(user);
        }
        Object principalToReturn = user;
        if (forcePrincipalAsString) {
            principalToReturn = user.getUsername();
        }
        return createSuccessAuthentication(principalToReturn, authentication, user);
    }

    protected Authentication createSuccessAuthentication(Object principal, Authentication authentication,
                                                         UserDetails user) {
        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(principal,
                authentication.getCredentials(), authoriesMapper.mapAuthorities(user.getAuthorities()));
        result.setDetails(authentication.getDetails());
        return result;
    }

    protected abstract UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException;

    /**
     * 模板方法，允许子类去实现额外的校验操作
     *
     * @param userDetails
     * @param authenticationToken
     * @throws AuthenticationException
     */
    protected abstract void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken
            authenticationToken) throws AuthenticationException;

    private class DefaultPreAuthenticationChecks implements UserDetailsChecker {

        public void check(UserDetails toCheck) {

        }
    }

    private class DefaultPostAuthenticationChecks implements UserDetailsChecker {

        public void check(UserDetails toCheck) {

        }
    }
}
