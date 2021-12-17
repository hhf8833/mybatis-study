package com.hhf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Alias("student")
public class Student {

    private int id;
    private String name;
    private int tid;
}
