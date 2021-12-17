package com.hhf.dao;


import com.hhf.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUserList();


    User getUserById(@Param("id") int id);

    @Insert("insert into user(id,name,pwd) values(#{id},#{name},#{password})")
    int  addUser(User user);

    @Update("update  user set name =#{name},pwd=#{password} where id =#{id} ")
    int updateUser(User user);

    @Delete("delete from user where id=#{uid}")
    int deleteUser(@Param("uid") int id );

    List<User> getUserByLimit(Map<String,Integer> map);
}
