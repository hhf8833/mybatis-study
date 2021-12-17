package com.hhf.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @author HP
 * @Data lomlolk
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("user")
public class User {
    private int id;
    private String name;
    private String password;


}
