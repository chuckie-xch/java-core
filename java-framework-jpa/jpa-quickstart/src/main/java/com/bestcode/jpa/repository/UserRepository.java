package com.bestcode.jpa.repository;

import com.bestcode.jpa.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.10
 */
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByName(String name);

    List<User> findByEmailAndName(String email, String name);
}
