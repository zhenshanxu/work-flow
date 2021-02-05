package com.example.workflow.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @BelongsProject: work-flow
 * @BelongsPackage: com.example.workflow.Bean
 * @Author: ZhenShan Xu
 * @CreateTime: 2021-02-05 09:45.
 * @Description: 用户信息
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserBean {

    private int id;

    private String name;

    private String email;
}
