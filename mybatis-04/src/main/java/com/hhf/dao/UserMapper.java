package com.hhf.dao;

import com.hhf.bean.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();
    User getUserById(int id);
    int  addUser(User user);
    int updateUser(User user);
    List<User> getUserByLimit(Map<String,Integer> map);
}
