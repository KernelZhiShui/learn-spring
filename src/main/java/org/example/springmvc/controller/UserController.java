package org.example.springmvc.controller;

import org.example.springmvc.bean.User;
import org.example.springmvc.common.Result;
import org.example.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/api/v1")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
    public Result<User> getUserById(@PathVariable("id") Long id) {
        Result<User> result;
        User userResult = userService.getUserById(id);
        result = Result.success(userResult);
        return result;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Result<List<User>> list(@RequestParam(value = "pageNum", required = false) Integer pageNum, @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        Result<List<User>> result;
        List<User> users;
        if (pageNum != null && pageSize != null) {
            users = userService.list(pageNum, pageSize);
        } else {
            users = userService.list();
        }
        result = Result.success(users);
        return result;
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json")
    public Result<User> addUser(@RequestBody User user) {
        Result<User> result;
        int resultNum = userService.addUser(user);
        if (resultNum > 0) {
            result = Result.success(user);
        } else {
            result = Result.error("添加失败");
        }
        return result;
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT, produces = "application/json")
    public Result<User> updateUser(@RequestBody User user) {
        Result<User> result;
        int resultNum = userService.updateUser(user);
        if (resultNum > 0) {
            result = Result.success(user);
        } else {
            result = Result.error("更新用户失败");
        }
        return result;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public Result<User> deleteUser(@PathVariable("id") Long id) {
        Result<User> result;
        int resultNum = userService.deleteUser(id);
        if (resultNum > 0) {
            result = Result.success(null);
        } else {
            result = Result.error("删除用户失败");
        }
        return result;
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result<String> exceptionHandler(Exception e) {
        return Result.error(500, e.getMessage());
    }
}
