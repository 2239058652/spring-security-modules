package com.dc.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class CaptchaFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String code = request.getParameter("captcha");
        String sessionCode = (String) request.getSession().getAttribute("captcha");

        String uri = request.getRequestURI();
        if ("/login".equals(uri) && (code == null || !code.equalsIgnoreCase(sessionCode))) {
            response.sendRedirect("/login?error=captcha");
            return;
        }
        filterChain.doFilter(request, response);
    }
}
