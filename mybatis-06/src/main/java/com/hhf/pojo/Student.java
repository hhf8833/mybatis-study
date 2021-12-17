package com.hhf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @author HP
 * 多对一的情况
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Alias("student")
public class Student {

    private int id;
    private String name;
    private Teacher teacher;
}
