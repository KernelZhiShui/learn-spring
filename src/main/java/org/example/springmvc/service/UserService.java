package org.example.springmvc.service;

import org.example.springmvc.bean.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(Long id);

    List<User> list();

    List<User> list(int pageNum, int pageSize);
}
