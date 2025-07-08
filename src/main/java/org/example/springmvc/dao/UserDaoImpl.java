package org.example.springmvc.dao;

import org.example.springmvc.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * @param id
     * @return
     */
    @Override
    public User getUserById(Long id) {
        User result = null;
        try {
            String sql = "select * from user where id = ?";
            result = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
        } catch (Exception e) {
            System.out.println("查询id为" + id + "的用户为空");
        } finally {
            System.out.println("查询id为" + id + "的用户" + result);
        }
        return result;
    }

    /**
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        String sql = "insert into user(username,id,age) values(?,?,?)";
        int result = jdbcTemplate.update(sql, user.getUsername(), user.getId(), user.getAge());
        System.out.println("添加了" + result + "条数据");
        return result;
    }

    /**
     * @param user
     * @return
     */
    @Override
    public int updateUser(User user) {
        String sql = "update user set username = ?,id = ?,age = ? where id = ?";
        int result = jdbcTemplate.update(sql, user.getUsername(), user.getId(), user.getAge(), user.getId());
        System.out.println("修改了" + result + "条数据");
        return result;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public int deleteUser(Long id) {
        String sql = "delete from user where id = ?";
        int result = jdbcTemplate.update(sql, id);
        System.out.println("删除了" + result + "条数据");
        return result;
    }

    /**
     * @return
     */
    @Override
    public List<User> list() {
        String sql = "select * from user";
        List<User> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return result;
    }

    /**
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<User> list(int pageNum, int pageSize) {
        String sql = "select * from user limit ?,?";
        List<User> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), (pageNum - 1) * pageSize, pageSize);
        return result;
    }
}
