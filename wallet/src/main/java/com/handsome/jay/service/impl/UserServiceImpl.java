package com.handsome.jay.service.impl;

import com.handsome.jay.entity.User;
import com.handsome.jay.dao.UserDao;
import com.handsome.jay.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jay
 * @since 2023-03-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}
