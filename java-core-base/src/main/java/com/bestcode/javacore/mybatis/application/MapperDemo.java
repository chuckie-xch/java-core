package com.bestcode.javacore.mybatis.application;

import com.bestcode.javacore.mybatis.entity.User;
import com.bestcode.javacore.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

/**
 * @author <a href="mailto:1205241831@qq.com">Xch</a>
 * @version 1.00
 * @see
 * @since 2018.05.08
 */
public class MapperDemo {

    public static void main(String[] args) throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        String name = "张三丰";
        user.setName(name);
        user.setAge(20);
        userMapper.save(user);
        List<User> result = userMapper.findByName(name);
        System.out.println(result);
    }
}
