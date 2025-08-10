package com.dc.controller;

import com.dc.util.LoginInfoUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class UserController {

    @RequestMapping("/index")
    @ResponseBody  // 这个注解返回字符串或者json，@Controller返回页面
    public String index(){
        return "welcome to spring security";
    }

    @GetMapping("/toLogin")
    public String toLogin(HttpServletRequest request) {
        // 打印会话状态用于调试
        System.out.println("访问toLogin - 会话ID: " + request.getSession().getId());
        return "login";
    }

    // 添加一个测试用的公开接口
    @GetMapping("/test-public")
    @ResponseBody
    public String testPublic() {
        return "这是公开内容";
    }

    @RequestMapping(value = "/welcome")
    @ResponseBody
    public Object welcome(Principal principal) {
        return principal;
    }

    @RequestMapping(value = "/welcome2")
    @ResponseBody
    public Object welcome2(Principal principal) {
        return LoginInfoUtil.getCurrentLoginUser();
    }
}
