package com.example.workflow.api;

import com.example.workflow.bean.ResponseBean;
import com.example.workflow.bean.UserBean;
import com.example.workflow.mapper.UserMapper;
import com.example.workflow.service.IUserService;
import com.example.workflow.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @BelongsProject: work-flow
 * @BelongsPackage: com.example.workflow.api
 * @Author: ZhenShan Xu
 * @CreateTime: 2021-02-01 15:55.
 * @Description:
 */
@RestController
public class UserApi {
    private static int DELETE_STATUS_1 = 1;

    @Autowired
    IUserService userService;

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

    /**
     * 根据手机号（用户名）修改密码
     *
     * @return
     */
    @PostMapping("/api/user/userUptdae")
    public ResponseBean userUpadate(@RequestBody UserBean userBean) {
        ResponseBean res = new ResponseBean();
        try {
            userService.userUpdate(userBean);
            res.setSuccess(true);
            res.setResult(userBean);
        } catch (Exception e) {
            res.setSuccess(false);
            res.setErrorMessage(e.getMessage());
        }
        return res;
    }

    @RequestMapping("/api/user/userAdd")
    public ResponseBean userAdd(@RequestBody UserBean userBean) {
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
}
