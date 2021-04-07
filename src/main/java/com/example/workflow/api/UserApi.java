package com.example.workflow.api;

import com.example.workflow.bean.ResponseBean;
import com.example.workflow.bean.UserBean;
import com.example.workflow.service.IUserService;
import com.example.workflow.utils.CommonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: work-flow
 * @BelongsPackage: com.example.workflow.api
 * @Author: ZhenShan Xu
 * @CreateTime: 2021-02-01 15:55.
 * @Description:
 */
@Api(tags = "用户管理")
@RestController
public class UserApi {

    @Autowired
    IUserService userService;


    /**
     * 查询用户
     *
     * @param userBean
     * @return
     */
    @ApiOperation("查询用户")
    @PostMapping("/api/user/queryUser")
    public ResponseBean queryUser(@RequestBody UserBean userBean) {
        ResponseBean res = new ResponseBean();
        try {
            List<UserBean> userList = userService.queryUser(userBean);
            res.setSuccess(true);
            res.setResult(userList);
        } catch (Exception e) {
            res.setSuccess(false);
            res.setErrorMessage(e.getMessage());
        }
        return res;
    }


    /**
     * 修改用户
     *
     * @return
     */
    @ApiOperation("修改用户")
    @PostMapping("/api/user/updateUser")
    public ResponseBean updateUser(@RequestBody UserBean userBean) {
        ResponseBean res = new ResponseBean();
        try {
            userService.updateUser(userBean);
            res.setSuccess(true);
            res.setResult(userBean);
        } catch (Exception e) {
            res.setSuccess(false);
            res.setErrorMessage(e.getMessage());
        }
        return res;
    }

    /**
     * 新增用户
     *
     * @param userBean
     * @return
     */
    @ApiOperation("新增用户")
    @RequestMapping("/api/user/addUser")
    public ResponseBean addUser(@RequestBody UserBean userBean) {
        ResponseBean res = new ResponseBean();
        try {
            userService.addUser(userBean);
            res.setSuccess(true);
            res.setResult(userBean);
        } catch (Exception e) {
            res.setSuccess(false);
            res.setErrorMessage(e.getMessage());
        }
        return res;
    }

    /**
     * 删除用户
     *
     * @param userBean
     * @return
     */
    @ApiOperation("删除用户")
    @RequestMapping("/api/user/deleteUser")
    public ResponseBean deleteUser(@RequestBody UserBean userBean) {
        ResponseBean res = new ResponseBean();
        try {
            userService.deleteUser(userBean);
            res.setSuccess(true);
            res.setResult("删除成功！");
        } catch (Exception e) {
            res.setSuccess(false);
            res.setErrorMessage(e.getMessage());
        }
        return res;
    }

}
