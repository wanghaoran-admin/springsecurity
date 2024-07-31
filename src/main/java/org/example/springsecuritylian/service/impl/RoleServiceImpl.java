package org.example.springsecuritylian.service.impl;

import org.example.springsecuritylian.entity.Role;
import org.example.springsecuritylian.mapper.RoleMapper;
import org.example.springsecuritylian.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
