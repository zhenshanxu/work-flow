package com.example.workflow.mapper;

import com.example.workflow.bean.UserBean;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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

@Repository
public interface UserMapper extends BaseMapper<UserBean> {

    /**
     * 查询用户
     *
     * @param userBean
     * @return
     */
    List<UserBean> queryUser(UserBean userBean);
    /**
     * 查询用户
     *
     * @param userBean
     * @return
     */
    List<UserBean> queryUserByPhone(UserBean userBean);
    /**
     * 新增用户
     * @return
     */
    String addUser(UserBean userBean);
    /**
     * 根据用户名修改信息
     */
    void userUpdate(UserBean userBean);
}
