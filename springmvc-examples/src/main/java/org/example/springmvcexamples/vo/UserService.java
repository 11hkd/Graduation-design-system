package org.example.springmvcexamples.vo;

import org.example.springmvcexamples.dox.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    // 初始化用户列表为空列表，后续可通过create方法进行填充
    private static List<User> USERS = new ArrayList<>();

    // 用于创建用户并初始化用户列表的方法，这里设置为public以便在合适时机调用
    public static void create() {
        List<User> users = new ArrayList<>();
        User u = User.builder()
                .id("1")
                .name("user1")
                .account("100")
                .password("123456")
                .build();
        users.add(u);
        USERS = users;
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
}