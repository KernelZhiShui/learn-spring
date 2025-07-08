package org.example.springmvc.service.impl;

import ch.qos.logback.core.util.StringUtil;
import org.example.springmvc.bean.User;
import org.example.springmvc.dao.UserDao;
import org.example.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * @param id
     * @return
     */
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    /**
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        // 判断数据库里有没有
        if (userDao.getUserById(user.getId()) != null) {
            System.out.println("用户已存在");
            return 0;
        }
        return userDao.addUser(user);
    }

    /**
     * @param user
     * @return
     */
    @Override
    public int updateUser(User user) {
        Long userId = user.getId();
        // 防止 user 为 null 或者 id 无效
        if (user == null || userId <= 0) {
            return 0;
        }
        // 去数据库查询原来的值
        User oldUser = userDao.getUserById(userId);
        // 将新值覆盖原值,没有的保留
        if (StringUtils.hasText(oldUser.getUsername())) {
            user.setUsername(oldUser.getUsername());
        }
        if (oldUser.getAge() > 0) {
            user.setAge(oldUser.getAge());
        }
        return userDao.updateUser(user);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public int deleteUser(Long id) {
        return userDao.deleteUser(id);
    }

    /**
     * @return
     */
    @Override
    public List<User> list() {
        return userDao.list();
    }

    /**
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<User> list(int pageNum, int pageSize) {
        return userDao.list(pageNum, pageSize);
    }
}
