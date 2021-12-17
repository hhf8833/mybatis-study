package com.hhf.dao;

import com.hhf.bean.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();
    User getUserById(int id);
    List<User> getUserLike(String namePart);
    int  addUser(User user);
    int  addUser2(Map<String,Object> map );
    int updateUser(User user);
}
