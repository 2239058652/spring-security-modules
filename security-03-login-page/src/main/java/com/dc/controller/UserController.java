package com.dc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

    @RequestMapping("/")
    @ResponseBody  // 这个注解返回字符串或者json，@Controller返回页面
    public String index(){
        return "welcome to spring security";
    }

    @RequestMapping(value = "/toLogin")
    public String toLogin(){
        return "login";
    }
}
