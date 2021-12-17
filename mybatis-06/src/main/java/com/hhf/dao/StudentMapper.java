package com.hhf.dao;

import com.hhf.pojo.Student;

import java.util.List;

public interface StudentMapper {
    //查询所有学生信息，以及对应的老师的信息
    public List<Student> getStudent();
    public List<Student> getStudent2();
}
