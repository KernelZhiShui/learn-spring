package org.example.springmvc.controller;

import jakarta.validation.Valid;
import org.example.springmvc.bean.User;
import org.example.springmvc.VO.AffectedRowsResult;
import org.example.springmvc.VO.Result;
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
    public Result<AffectedRowsResult> addUser(@RequestBody @Valid User user) {
        Result<AffectedRowsResult> result;
        int resultNum = userService.addUser(user);
        AffectedRowsResult affectedRowsResult = new AffectedRowsResult();
        affectedRowsResult.setAffectedRows(resultNum);
        if (resultNum > 0) {
            result = Result.success(affectedRowsResult);
        } else {
            result = Result.error("添加失败");
        }
        return result;
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT, produces = "application/json")
    public Result<AffectedRowsResult> updateUser(@RequestBody @Valid User user) {
        Result<AffectedRowsResult> result;
        int resultNum = userService.updateUser(user);
        AffectedRowsResult affectedRowsResult = new AffectedRowsResult();
        affectedRowsResult.setAffectedRows(resultNum);
        if (resultNum > 0) {
            result = Result.success(affectedRowsResult);
        } else {
            result = Result.error("更新用户失败");
        }
        return result;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public Result<AffectedRowsResult> deleteUser(@PathVariable("id") Long id) {
        Result<AffectedRowsResult> result;
        int resultNum = userService.deleteUser(id);
        AffectedRowsResult affectedRowsResult = new AffectedRowsResult();
        affectedRowsResult.setAffectedRows(resultNum);
        if (resultNum > 0) {
            result = Result.success(affectedRowsResult);
        } else {
            result = Result.error("删除用户失败");
        }
        return result;
    }
}
