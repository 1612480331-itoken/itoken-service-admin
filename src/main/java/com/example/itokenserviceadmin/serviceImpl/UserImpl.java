package com.example.itokenserviceadmin.serviceImpl;

import com.example.itokenserviceadmin.entity.User;
import com.example.itokenserviceadmin.mapper.UserMapper;
import com.example.itokenserviceadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

@Service
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class UserImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectAll(String id) {
        return userMapper.selectAll(id);
    }

    @Transactional    //默认readonly为false
    @Override
    public int register(User user) {
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        System.out.println(user);
        return userMapper.insert(user);
    }

    @Override
    public User login(String id, String password) {
        User user=userMapper.selectAll(id);
        String passwordMd5=DigestUtils.md5DigestAsHex(password.getBytes());
        if(passwordMd5.equals(user.getPassword())){
            return user;
        }
        return null;
    }
}
