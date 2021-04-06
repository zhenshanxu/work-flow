package com.example.workflow.service;

import com.example.workflow.bean.UserBean;

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
     * @param userBean
     */
    void userUpdate (UserBean userBean);
    /**
     * 根据手机号（用户名）查询用户信息
     * @param phone
     */
    UserBean queeryUserByPhone(String phone);

    /**
     * 新建用户
     */
    void addUser(UserBean userBean);

    UserBean queeryUser(String id);
}
