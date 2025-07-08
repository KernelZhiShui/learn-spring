package org.example.springmvc.service;

import org.example.springmvc.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestUserService {
    @Autowired
    private UserService userService;

    @Test
    public void testGetUserById() {
        System.out.println(userService.getUserById(1L));
    }

    @Test
    public void testAddUser() {
        User user = new User("test", 1L, 18);
        System.out.println(userService.addUser(user));
    }

    @Test
    public void testUpdateUser() {
        User user = new User("test", 1L, 18);
        System.out.println(userService.updateUser(user));
    }

    @Test
    public void testDeleteUser() {
        System.out.println(userService.deleteUser(1L));
    }

    @Test
    public void testList() {
        System.out.println(userService.list());
    }

    @Test
    public void testListPage() {
        System.out.println(userService.list(1, 2));
    }
}
