package com.example.itokenserviceadmin.mapper;

import com.example.itokenserviceadmin.entity.User;

public interface UserMapper {
    User selectAll(String id);
    int insert(User user);
}
