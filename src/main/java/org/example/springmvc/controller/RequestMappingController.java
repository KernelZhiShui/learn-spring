package org.example.springmvc.controller;

import org.example.springmvc.bean.Person;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class RequestMappingController {
    @RequestMapping(value = "/test01",method = RequestMethod.POST)
    public String test01() {
        return "test01";
    }

    @RequestMapping("/test02")
    public String test02(@RequestBody Person person) {
        System.out.println(person);
        return "test02";
    }

    @RequestMapping("/test03")
    public String test03(@RequestParam("file") MultipartFile file, @RequestParam("username") String username) {
        try {
          InputStream fileText = file.getInputStream();
            String fileName = file.getOriginalFilename();
            System.out.println("fileText:"+fileText.toString());
            System.out.println("fileName:"+fileName);
            System.out.println("username:"+username);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "test03";
    }

    @RequestMapping("/test04")
    public String test04(HttpEntity<Person> httpEntity) {
        System.out.println("httpEntity:"+httpEntity.getBody());
        return "test03";
    }
}
