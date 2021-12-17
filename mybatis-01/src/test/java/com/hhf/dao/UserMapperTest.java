package com.hhf.dao;

import com.hhf.bean.User;
import com.hhf.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.omg.CORBA.MARSHAL;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public void test(){
        //获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{
            //方式一 getmapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();
            for (User user :
                    userList) {
                System.out.println(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        sqlSession.close();
    }
    @Test
    public void testAddUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.addUser(new User(6, "哈哈", "213142"));
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testUpdateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(1,"叫啥","111111"));
        sqlSession.close();
    }
    @Test
    public void testAddUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> userMap = new HashMap<String, Object>();
        userMap.put("userid",7);
        userMap.put("username","map添加");
        userMap.put("userpwd","12342");
        mapper.addUser2(userMap);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testgetUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.getUserLike("哈哈");
        for (User i :
                userList) {
            System.out.println(i);
        }
        sqlSession.close();
    }
}
