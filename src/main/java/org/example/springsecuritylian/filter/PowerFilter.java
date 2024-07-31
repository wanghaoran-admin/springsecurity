package org.example.springsecuritylian.filter;

import org.example.springsecuritylian.springsecurity.UserDetail;
import org.example.springsecuritylian.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Component
public class PowerFilter extends OncePerRequestFilter {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println(1);
        String token = httpServletRequest.getHeader("token");


        //验证令牌必须是字符串类型
        if (!StringUtils.hasText(token)) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        Map map = new HashMap();
        try {
            map = JwtUtil.parseToken(token);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("令牌失效!");
        }

        UserDetail loginUser = (UserDetail) redisTemplate.boundValueOps("login:" +map.get("name")).get();
        System.out.println("redis中的数据"+loginUser);

        if (ObjectUtils.isEmpty(loginUser)) {
            throw new RuntimeException("没有数据!");
        }

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());

        System.out.println(usernamePasswordAuthenticationToken);

        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        //放行接口
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
