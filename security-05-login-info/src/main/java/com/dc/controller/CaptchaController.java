package com.dc.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ICaptcha;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class CaptchaController {

    @RequestMapping("/common/captcha")
    public void generateCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("image/png");
        // 生成验证码图片
        ICaptcha captcha = CaptchaUtil.createCircleCaptcha(150, 30, 4, 0, 1);

        // 将验证码存入 session
        request.getSession().setAttribute("captcha", captcha.getCode());

        // 将验证码图片输出到浏览器
        captcha.write(response.getOutputStream());
    }
}
