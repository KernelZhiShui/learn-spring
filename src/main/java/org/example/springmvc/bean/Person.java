package org.example.springmvc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    private String username;
    private int age;
    private String sex;
    private Address address;
    private String phone;
    private String email;
}

