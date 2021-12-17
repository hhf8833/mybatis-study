package com.hhf.dao;

import com.hhf.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUserList();

    //方法存在多个参数所有参数必须要在前面加上@Param（）注解，
    // 这里并不能代替resultMap因为，他只是决定了数据库查询的参数，返回的结果并不能对应上，pwd和password在返回后仍然不能对上还是null
    @Select("select * from user where id =#{ID}")
    User getUserById(@Param("ID") int id);

    @Insert("insert into user(id,name,pwd) values(#{id},#{name},#{password})")
    int  addUser(User user);

    @Update("update  user set name =#{name},pwd=#{password} where id =#{id} ")
    int updateUser(User user);

    @Delete("delete from user where id=#{uid}")
    int deleteUser(@Param("uid") int id );

    List<User> getUserByLimit(Map<String,Integer> map);
}
