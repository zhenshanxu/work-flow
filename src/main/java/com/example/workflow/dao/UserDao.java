package com.example.workflow.dao;

import com.example.workflow.bean.UserBean;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author snail
 * @since 2021-04-05
 */

@Mapper
public interface UserDao extends BaseMapper<UserBean> {

    /**
     * 查询用户
     *
     * @param userBean
     * @return
     */
    List<UserBean> queryUser(UserBean userBean);


    /**
     * 新增用户
     *
     * @return
     */
    void addUser(UserBean userBean);

    /**
     * 根据用户名修改信息
     */
    void updateUser(UserBean userBean);
}
