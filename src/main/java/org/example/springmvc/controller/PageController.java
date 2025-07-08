package org.example.springmvc.controller;

import org.example.springmvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import java.util.List;

@Controller
public class PageController {

    @RequestMapping("/")
    public String page() {
        return "login";
    }

    @RequestMapping("/login.do")
    public String login(String username, String password, Model model) {
        System.out.println("用户登录:"+username+",password:"+password);
        model.addAttribute("name","小明");
        model.addAttribute("age",12);

       List<User> users = Arrays.asList(
                new User("小明",1L,12),
                new User("小王",2L,13),
                new User("小李",3L,14)
        );
       model.addAttribute("users",users);
        return "page/success";
    }
}
