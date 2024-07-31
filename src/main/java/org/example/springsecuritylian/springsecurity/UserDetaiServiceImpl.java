package org.example.springsecuritylian.springsecurity;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.springsecuritylian.entity.User;
import org.example.springsecuritylian.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetaiServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println(3);
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,s);
        User user = userMapper.selectOne(queryWrapper);
        if (user==null) throw new UsernameNotFoundException("用户不存在！！！");
        System.out.println("验证身份的用户:"+user);
        List<String> permissions = new ArrayList<>();
        permissions.add("admin");
        permissions.add("cscscs");
        return new UserDetail(user,permissions);
    }
}
