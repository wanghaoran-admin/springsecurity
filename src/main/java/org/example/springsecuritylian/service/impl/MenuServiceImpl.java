package org.example.springsecuritylian.service.impl;

import org.example.springsecuritylian.entity.Menu;
import org.example.springsecuritylian.mapper.MenuMapper;
import org.example.springsecuritylian.service.IMenuService;
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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
