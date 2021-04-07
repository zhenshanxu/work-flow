package com.example.workflow.service;

import com.example.workflow.bean.UserBean;

import java.util.List;
import java.util.Map;

public interface IUserService {

    /**
     * 用户登录
     *
     * @param userBean
     * @return
     */
    Map<String, Object> userLogin(UserBean userBean);

    /**
     * 修改用户信息
     *
     * @param userBean
     */
    void updateUser(UserBean userBean);

    /**
     * 新建用户
     */
    void addUser(UserBean userBean);

    /**
     * 查询用户
     *
     * @param userBean
     * @return
     */
    List<UserBean> queryUser(UserBean userBean);

    /**
     * 删除用户
     *
     * @param userBean
     */
    void deleteUser(UserBean userBean);
}
