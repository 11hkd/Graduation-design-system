package org.example.springmvcexamples.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springmvcexamples.dox.User;
import org.example.springmvcexamples.exception.Code;
import org.example.springmvcexamples.vo.ResultVO;
import org.example.springmvcexamples.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class LoginController {


private final UserService userService;
    @PostMapping("login")
    public ResultVO login(@RequestBody User user) {
        User userByAccount = userService.getUserByAccount(user.getAccount(), user.getPassword());
        if (userByAccount == null) {
            return ResultVO.error(Code.LOGIN_ERROR);
        }
        return ResultVO.success(userByAccount);
    }
}
