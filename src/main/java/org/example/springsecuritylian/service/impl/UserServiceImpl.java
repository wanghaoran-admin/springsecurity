package org.example.springsecuritylian.service.impl;

import org.example.springsecuritylian.entity.User;
import org.example.springsecuritylian.mapper.UserMapper;
import org.example.springsecuritylian.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-07-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
