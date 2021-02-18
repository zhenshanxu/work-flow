package com.example.workflow.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

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

    @Id
    private int id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 邮件
     */
    private String email;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 密码
     */
    private String password;
}
