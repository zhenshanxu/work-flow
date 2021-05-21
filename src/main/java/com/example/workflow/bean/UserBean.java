package com.example.workflow.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import io.swagger.annotations.ApiModelProperty;

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
public class UserBean extends AssistBean {

    @Id
    private int id;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String name;

    /**
     * 邮件
     */
    @ApiModelProperty("邮件")
    private String email;

    /**
     * 联系方式
     */
    @ApiModelProperty("联系方式")
    private String phone;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 状态，是否删除 1：正常，0删除
     */
    @ApiModelProperty("状态，是否删除 1：正常，0：删除")
    private int isDelete;
}
