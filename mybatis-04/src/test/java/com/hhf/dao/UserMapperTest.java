package com.hhf.dao;

import com.hhf.bean.User;
import com.hhf.dao.UserMapper;
import com.hhf.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {
    static Logger logger = Logger.getLogger(UserMapperTest.class);
    @Test
    public void testGetUser(){
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
        User userById = mapper.getUserById(2);
        System.out.println(userById);
        sqlSession.close();
    }
    @Test
    public void testAddUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.addUser(new User(8, "哈哈", "213142"));
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
    public void testLog4j(){
       logger.info("进入了info");
       logger.debug("进入了debug");
       logger.error("进入了error");
    }
    @Test
    public  void testGetUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex",0);
        map.put("pageSize",2);

        List<User> userList = mapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }
}
