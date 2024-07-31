package org.example.springsecuritylian.controller;


import org.example.springsecuritylian.service.IUserService;
import org.example.springsecuritylian.springsecurity.UserDetail;
import org.example.springsecuritylian.utils.JwtUtil;
import org.example.springsecuritylian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2024-07-30
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("show")
    @PreAuthorize("hasAuthority('admin')")
    public String show(){
        return "你好!!";
    }

    @GetMapping("show1")
    @PreAuthorize("hasAuthority('admin1')")
    public String show1(){
        return "你好!!1";
    }

    @GetMapping("login")
    public Result login(String name,String pwd){
        System.out.println(2);

        // 身份验证令牌
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(name, pwd);

        //身份验证
        Authentication authenticate = null;
        authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        UserDetail loginUser = (UserDetail) authenticate.getPrincipal();
        Map map = new HashMap();
        map.put("name",loginUser.getUser().getUserName());
        String token = JwtUtil.genToken(map);

        // 用户存储到 redis
        redisTemplate.boundValueOps("login:" + loginUser.getUser().getUserName()).set(loginUser);

        Map<String, String> map1 = new HashMap<>();
        map1.put("token", token);

        return new Result(200, map1, "认证通过！");
    }
}
