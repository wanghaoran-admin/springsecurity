package org.example.springsecuritylian.handle;

import com.alibaba.fastjson.JSON;
import org.example.springsecuritylian.utils.Result;
import org.example.springsecuritylian.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        Result r = new Result(500,HttpStatus.FORBIDDEN.value(), "用户认证失败！");
        WebUtils.renderString(response, JSON.toJSONString(r));
    }
}
