package com.hhf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author HP
 * @Data lomlolk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("user")
//当开启二级缓存后<cache/>，需要Serializable，不然会报错
public class User implements Serializable {
    private int id;
    private String name;
    private String pwd;


}
