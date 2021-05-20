package com.example.workflow.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: work-flow
 * @BelongsPackage: com.example.workflow.bean
 * @Author: ZhenShan Xu
 * @CreateTime: 2021-02-19 09:49.
 * @Description: 请求发回
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBean {

    /**
     * 请求状态 true：成功 false：失败
     */
    private Boolean success;

    /**
     * 请求结果
     */
    private Object result;

    /**
     * 错误信息
     */
    private String errorMessage;

    /**
     * 额外信息
     */
    private Object extraMessage;

}
