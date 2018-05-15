package com.bestcode.security.authentication.dao;

import com.bestcode.security.authentication.UsernamePasswordAuthenticationToken;
import com.bestcode.security.authentication.encoding.PasswordEncoder;
import com.bestcode.security.core.AuthenticationException;
import com.bestcode.security.core.userdetails.UserDetails;
import com.bestcode.security.core.userdetails.UserDetailsService;
import com.bestcode.security.core.userdetails.UsernameNotFoundException;

/**
 * 基于数据库的认证服务
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.15
 */
public class DaoAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private PasswordEncoder passwordEncoder;
    private UserDetailsService userDetailsService;

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws
            AuthenticationException {
        UserDetails loadUser;
        try {
            loadUser = userDetailsService.loadUserByUsername(username);
        } catch (UsernameNotFoundException e) {
            throw e;
        }
        return loadUser;
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken
            authenticationToken) throws AuthenticationException {

    }
}
