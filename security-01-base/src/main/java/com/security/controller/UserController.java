package com.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 这个注解返回字符串或者json，@Controller返回页面
public class UserController {

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello, Spring Security";
    }
}
