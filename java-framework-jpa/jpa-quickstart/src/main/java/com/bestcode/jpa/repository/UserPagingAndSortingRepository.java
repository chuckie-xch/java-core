package com.bestcode.jpa.repository;

import com.bestcode.jpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.10
 */
public interface UserPagingAndSortingRepository extends PagingAndSortingRepository<User, Long> {


    Page<User> findByName(String name, Pageable pageable);
}
