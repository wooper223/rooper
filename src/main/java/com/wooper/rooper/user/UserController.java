package com.wooper.rooper.user;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/user/signup")
    public String signup(@RequestBody UserVo userVo){
        return userService.insertUser(userVo).toString();
    }

    @PostMapping("/user/login")
    public String login(LoginVo loginVo, HttpServletRequest request){
        return userService.login(loginVo, request).toString();
    }

    @PostMapping("/user/logout")
    public String logout(HttpServletRequest request){
        return userService.logout(request).toString();
    }

    @GetMapping("/user/allUserInfo")
    public String allUserInfo(){
        return userService.getAllUserInfo();
    }
}