package com.bestcode.provider;

import com.bestcode.api.entity.User;
import com.bestcode.api.service.UserService;

import java.util.Random;
import java.util.RandomAccess;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.08
 */
public class UserServiceImpl implements UserService {

    public User findByName(String name) {
        User user = new User();
        user.setId(0L);
        user.setName(name);
        Random random = new Random();
        user.setAge(random.nextInt(100));
        return user;
    }
}
