package com.example.springbootgoodsdemo.service.impl;

import com.example.springbootgoodsdemo.entity.User;
import com.example.springbootgoodsdemo.mapper.UserMapper;
import com.example.springbootgoodsdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User selectUserByName(String uname) {
        return userMapper.selectUserByName(uname);
    }

//    @Override
//    public User selectByName(String uname) {
//        User user = userMapper.selectByName(uname);
//
//    }
}
