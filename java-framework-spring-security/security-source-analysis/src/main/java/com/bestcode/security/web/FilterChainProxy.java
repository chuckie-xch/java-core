package com.bestcode.security.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.filter.GenericFilterBean;

/**
 * Spring Security boot starter 中提供了自动装配的类SecurityFilterAutoConfiguration
 * 会在自动装配的bean里注册DelegatingFilterProxy,这个类是spring web提供的，相当于springSecurityFilterChain的门面，
 * 在执行doFilter时会委托代理过滤器即FilterChainProxy来执行doFilter操作
 *
 * @author xch
 * @create 2018-05-17 23:08
 **/
public class FilterChainProxy extends GenericFilterBean {

    private List<SecurityFilterChain> filterChains;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    }
}
