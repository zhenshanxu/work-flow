package com.example.workflow.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @BelongsProject: work-flow
 * @BelongsPackage: com.example.workflow.bean
 * @Author: ZhenShan Xu
 * @CreateTime: 2021-02-20 10:51.
 * @Description: 实体类辅助信息
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AssistBean {

    /**
     * 创建者
     */
    private int creator;
    /**
     * 修改者
     */
    private int mender;
    /**
     * 创建时间
     */
    private long createTime;
    /**
     * 修改时间
     */
    private long modifyTime;
}
