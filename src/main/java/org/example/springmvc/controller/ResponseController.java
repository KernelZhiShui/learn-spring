package org.example.springmvc.controller;

import org.example.springmvc.bean.Address;
import org.example.springmvc.bean.Person;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@RestController
public class ResponseController {
    @ResponseBody
    @RequestMapping("/getData")
    public Person getData() {
        Person person = new Person();
        person.setUsername("张三");
        person.setAge(18);
        person.setSex("男");
        person.setEmail("<EMAIL>");
        person.setPhone("12345678901");
        Address address = new Address();
        address.setCity("上海");
        address.setStreet("上海路");
        address.setZipCode("200000");
        person.setAddress(address);
        System.out.println(person);
        return person;
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> downloadFile() throws IOException {
        // 从资源目录读取文件（例如 src/main/resources/static/test.txt）
        ClassPathResource resource = new ClassPathResource("static/test.txt");

        byte[] fileData = Files.readAllBytes(resource.getFile().toPath());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", URLEncoder.encode("新建文件.txt", StandardCharsets.UTF_8)); // 文件名
        headers.setContentLength(fileData.length);

        return ResponseEntity.ok()
                .headers(headers)
                .body(fileData);
    }
}
