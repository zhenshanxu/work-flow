package com.example.workflow.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @BelongsProject: work-flow
 * @BelongsPackage: com.example.workflow.util
 * @Author: ZhenShan Xu
 * @CreateTime: 2021-02-01 15:56.
 * @Description:
 */

@Component
public class CommonUtil {


    public static int ZERO = 0;

    /**
     * 有效时间
     */
    public static final long EXPIRE_TIME = 15 * 60 * 1000;

    /**
     * token有效时间(365*24小时)
     */
    public static final long TOKEN_EXPIRE_TIME =  24 * 60 * 60 * 1000L;

    /**
     * 私钥
     */
    public static final String TOKEN_SECRET = "unique encryption encoding";

    /**
     * JWT_ID
     */
    public static final String JWT_ID = UUID.randomUUID().toString();

    /**
     * 默认
     */
    public static final int IS_DEFAULT = 1;

    /**
     * 隐藏的
     */
    public static final int HIDDEN = 2;

    /**
     * 删除状态1
     */
    public static int DELETE_STATUS_1 = 1;
    /**
     * 删除状态1
     */
    public static int DELETE_STATUS_2 = 2;

    /**
     * 错误值
     */
    public static String ERROR_VALUE = "error";
}
