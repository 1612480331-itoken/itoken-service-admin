package com.example.itokenserviceadmin.service;

import com.example.itokenserviceadmin.entity.User;

public interface UserService {
    User selectAll(String id);
    int register(User user);
    User login(String id,String password);
}
