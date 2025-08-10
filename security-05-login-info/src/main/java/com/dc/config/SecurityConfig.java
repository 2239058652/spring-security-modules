package com.dc.config;

import com.dc.filter.CaptchaFilter;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity  // 开启spring security
public class SecurityConfig {

    @Resource
    private CaptchaFilter captchaFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();    // 生产环境使用
    }

    //配置spring security框架的一些行为（配置自己的登录页，不要框架默认的）
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.formLogin(form -> form
                        .loginPage("/toLogin")          // 自定义登录页路由
                        .loginProcessingUrl("/login")   // 登录表单提交地址
                        .defaultSuccessUrl("/index", true)  // 登录成功跳转
                        .failureUrl("/toLogin?error")   // 登录失败跳转
                        .permitAll()
                        .successForwardUrl("/welcome")// 允许访问登录页相关
                )
                .authorizeHttpRequests(auth -> auth
                        // 放行所有登录相关路径和静态资源
                        .requestMatchers("/toLogin", "/login", "/common/captcha", "/css/**", "/js/**", "/images/**")
                        .permitAll()
                        // 其他所有请求需要认证
                        .anyRequest().authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable)  // 开发环境临时关闭
                // 处理框架默认的登录页重定向
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .permitAll()
                )
                .addFilterBefore(captchaFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}