package cn.nmmpa.user.service.impl;

import cn.nmmpa.user.model.User;
import cn.nmmpa.user.service.IUserService;
import cn.nmmpa.common.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import cn.nmmpa.user.mapper.UserMapper;

/**
 * @author TanShuai
 * @version 1.0 2019年8月26日
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper , User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserMapper getMapper(){ 
       return userMapper;
    }

}