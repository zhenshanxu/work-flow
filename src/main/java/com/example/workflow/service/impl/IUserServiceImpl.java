package com.example.workflow.service.impl;

import com.example.workflow.bean.UserBean;
import com.example.workflow.dao.UserDao;
import com.example.workflow.service.IUserService;
import com.example.workflow.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IUserServiceImpl implements IUserService {

    private final UserDao userMapper;

    @Autowired
    public IUserServiceImpl(UserDao userMapper) {
        this.userMapper = userMapper;
    }


    /**
     * 用户登录
     *
     * @param userBean
     * @return
     */
    @Override
    public Map<String, Object> userLogin(UserBean userBean) {
        Map<String, Object> flag = new HashMap<>();
        String phone = userBean.getPhone();

        UserBean user = new UserBean();
        user.setPhone(phone);
        List<UserBean> users = userMapper.queryUser(user);
        if (users.size() == 0) {
            flag.put(CommonUtil.ERROR_VALUE, "用户不存在！");
            return flag;
        }

        String passwprd = userBean.getPassword();
        UserBean userBean1 = users.get(0);
        if (!userBean1.getPassword().equals(passwprd)) {// password需要加密处理
            flag.put(CommonUtil.ERROR_VALUE, "用户密码错误！");
            return flag;
        }
        // todo 获取用户信息生成token ，并存储在Redis中
        flag.put("user", userBean1);
        return flag;
    }

    /**
     * 更新用户
     *
     * @param userBean
     */
    @Override
    public void updateUser(UserBean userBean) {
        userMapper.updateUser(userBean);
    }

    /**
     * 添加用户
     *
     * @param userBean
     */
    @Override
    public void addUser(UserBean userBean) {
        userMapper.addUser(userBean);
    }

    /**
     * 查询用户
     *
     * @param userBean
     * @return
     */
    @Override
    public List<UserBean> queryUser(UserBean userBean) {
        return userMapper.queryUser(userBean);
    }

    @Override
    public void deleteUser(UserBean userBean) {

    }


}
