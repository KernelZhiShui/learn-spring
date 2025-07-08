package org.example.springmvc.dao;

import org.example.springmvc.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    /**
     * 测试查询用户
     */
    @Test
    void testSelectUserById() {
        User user = userDao.getUserById(1L);
        System.out.println( user);
    }

    /**
     * 测试添加用户
     */
    @Test
    void testAddUser() {
        User user = new User();
        user.setUsername("test");
        user.setId(1L);
        user.setAge(18);
        int result = userDao.addUser(user);
        System.out.println(result);
    }

    /**
     * 测试更新用户
     */
    @Test
    void testUpdateUser() {
        User user = new User();
        user.setUsername("test");
        user.setId(1L);
        user.setAge(18);
        int result = userDao.updateUser(user);
        System.out.println(result);
    }

    /**
     * 测试删除用户
     */
    @Test
    void testDeleteUser() {
        int result = userDao.deleteUser(1L);
        System.out.println(result);
    }

    /**
     * 测试查询所有用户
     */
    @Test
    void testList() {
        System.out.println(userDao.list());
    }

    /**
     * 测试分页查询用户
     */
    @Test
    void testListPage() {
        System.out.println(userDao.list(1, 2));
    }

}
