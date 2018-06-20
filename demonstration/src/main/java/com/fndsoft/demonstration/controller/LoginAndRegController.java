package com.fndsoft.demonstration.controller;

import com.fndsoft.demonstration.config.LoginResult;
import com.fndsoft.demonstration.entity.User;
import com.fndsoft.demonstration.service.LoginAndRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @创建人 bob
 * @创建时间 2018/6/5
 * @描述：
 */
@CrossOrigin(origins = "*", maxAge = 3600)      //跨域
@RestController
public class LoginAndRegController {

    @Autowired
    LoginAndRegisterService loginAndRegService;

    @RequestMapping(value = "/api/login",method = RequestMethod.POST)
    public LoginResult verifyUser(@RequestBody User user) {
        LoginResult loginResult = new LoginResult();
        boolean bUser = loginAndRegService.verifyUser(user);
        if (bUser == true) {
            loginResult.setMsg("登录成功");
            loginResult.setResult(true);
        }if (bUser == false) {
            loginResult.setMsg("登录失败");
            loginResult.setResult(false);
        }
        return loginResult;
    }
}
