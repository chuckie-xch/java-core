package com.bestcode.study.webflux.hander;

import com.bestcode.study.webflux.domain.User;
import com.bestcode.study.webflux.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.12.07
 */
@Component
public class UserHandler {


    private final UserRepository userRepository;

    @Autowired
    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> save(User city) {
        return userRepository.save(city);
    }

    public Mono<User> update(User user) {
        return userRepository.save(user);
    }

    public Mono<Long> delete(Long id) {
         userRepository.deleteById(id);
         return Mono.create(userMonoSink -> userMonoSink.success(id));
    }

    public Mono<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public Flux<User> findAll() {
        return userRepository.findAll();
    }
}
