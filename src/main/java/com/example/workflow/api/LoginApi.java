package com.example.workflow.api;

import com.example.workflow.bean.ResponseBean;
import com.example.workflow.bean.UserBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation("用户登录")
    @PostMapping("/api/login")
    public ResponseBean login(@RequestBody UserBean userBean) {
        ResponseBean response = new ResponseBean();
        try {
            response.setSuccess(true);
            response.setResult(userBean);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setErrorMessage("用户名或者密码错误！");
        }
        return response;
    }

    ;
}
