package com.hhf.dao;

import com.hhf.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    //获取老师
    List<Teacher>  getTeacher();

    //获取指定老师下的所有学生及自己的信息
    Teacher getTeacher2(@Param("teaid") int id);
}
