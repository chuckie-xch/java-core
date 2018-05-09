package com.bestcode.api.service;

import com.bestcode.api.entity.User;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.08
 */
public interface UserService {

    User findByName(String name);
}
