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
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @BelongsProject: work-flow
 * @BelongsPackage: com.example.workflow.api
 * @Author: ZhenShan Xu
 * @CreateTime: 2021-02-19 09:41.
 * @Description: 登录接口
 */

@Api(tags = "登录管理")
@RestController
public class LoginApi {

    @Autowired
    IUserService userService;

    @ApiOperation("用户登录")
    @PostMapping("/api/user/userLogin")
    public ResponseBean userLogin(@RequestBody UserBean userBean) {
        ResponseBean response = new ResponseBean();
        try {
            Map<String, Object> flag = userService.userLogin(userBean);
            if (flag.containsKey(CommonUtil.ERROR_VALUE)) {
                response.setSuccess(false);
                response.setErrorMessage(flag.get(CommonUtil.ERROR_VALUE).toString());
            } else {
                response.setSuccess(true);
                response.setResult(flag);
            }

        } catch (Exception e) {
            response.setSuccess(false);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }
}
