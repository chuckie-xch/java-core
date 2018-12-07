package com.bestcode.study.webflux.repository;


import com.bestcode.study.webflux.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户仓储
 *
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.12.07
 */
@Repository
public interface UserRepository extends ReactiveMongoRepository<User, Long> {

}
