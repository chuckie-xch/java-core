package com.bestcode.security.core.userdetails;

/**
 * UserDetails缓存
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.15
 */
public interface UserCache {

    UserDetails getUserFromCache(String username);

    void putUserInCache(UserDetails userDetails);

    void removeUserFromCache(String username);
}
