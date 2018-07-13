package com.bestcode.jpa.controller;

import com.bestcode.jpa.entity.User;
import com.bestcode.jpa.repository.UserPagingAndSortingRepository;
import com.bestcode.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.07.10
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPagingAndSortingRepository userPagingAndSortingRepository;

    @PostMapping("/add")
    public void add(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
    }

    @GetMapping("/findAll")
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> findOne(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @PostMapping("/findByPage")
    public Page<User> findAllByPage(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        return userPagingAndSortingRepository.findAll(PageRequest.of(pageNum, pageSize, new Sort(Sort.Direction.DESC,
                "id")));
    }

}
