package com.bestcode.javacore.mybatis.mapper;

import com.bestcode.javacore.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.08
 */
public interface UserMapper {

    void save(User user);

    List<User> findByName(@Param("name") String name);
}
