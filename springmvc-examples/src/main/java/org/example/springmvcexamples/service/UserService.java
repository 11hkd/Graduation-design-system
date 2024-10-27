package org.example.springmvcexamples.service;

import org.example.springmvcexamples.dox.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static final List<User> USERS = create();
    private static List<User> create(){
        User u=User.builder()
                .id("1")
                .name("张三")
                .account("hkd")
                .password("123456")
                .build();
        return List.of(u);
    }

    // 获取所有用户列表的方法，符合命名规范
    public List<User> listUsers() {
        return USERS;
    }

    // 根据账户和密码获取用户的方法
    public User getUserByAccount(String account, String password) {
        // 使用流的方式先按账户过滤，再按密码过滤，找到匹配的第一个用户或返回null
        return USERS.stream()
                .filter(u -> u.getAccount().equals(account))
                .filter(u -> u.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
    public User getUserByAccount(String account) {
        // 使用流的方式先按账户过滤，再按密码过滤，找到匹配的第一个用户或返回null
        return USERS.stream()
                .filter(u -> u.getAccount().equals(account))
                .findFirst()
                .orElse(null);
    }
}