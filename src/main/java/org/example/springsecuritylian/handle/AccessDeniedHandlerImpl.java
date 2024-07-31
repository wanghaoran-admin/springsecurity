package org.example.springsecuritylian.handle;

import com.alibaba.fastjson.JSON;
import org.example.springsecuritylian.utils.Result;
import org.example.springsecuritylian.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Result r = new Result(500,HttpStatus.FORBIDDEN.value(), "用户权限不足!");
        WebUtils.renderString(response, JSON.toJSONString(r));
    }
}
