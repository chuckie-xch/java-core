package com.bestcode.security.core.userdetails.cache;

import com.bestcode.security.core.userdetails.UserCache;
import com.bestcode.security.core.userdetails.UserDetails;

/**
 * UserDetails不使用缓存
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.15
 */
public class NullUserCache implements UserCache{

    public UserDetails getUserFromCache(String username) {
        return null;
    }

    public void putUserInCache(UserDetails userDetails) {

    }

    public void removeUserFromCache(String username) {

    }
}
