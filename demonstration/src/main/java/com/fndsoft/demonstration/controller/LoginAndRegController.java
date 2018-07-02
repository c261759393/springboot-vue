package com.fndsoft.demonstration.controller;

import com.fndsoft.demonstration.config.LoginResult;
import com.fndsoft.demonstration.entity.User;
import com.fndsoft.demonstration.service.LoginAndRegisterService;
import com.fndsoft.demonstration.util.TokenUtil;
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

    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping(value = "/api/login",method = RequestMethod.POST)
    public LoginResult verifyUser(@RequestBody User user) {
        LoginResult loginResult = new LoginResult();
        boolean bUser = loginAndRegService.verifyUser(user);
        if (bUser == true) {

            User user1 = loginAndRegService.findByUsername(user.getUsername());

            loginResult.setName(user1.getName());
            loginResult.setMsg("登录成功");
            loginResult.setResult(true);
            loginResult.setToken(TokenUtil.getToken(user.getUsername()));
        }if (bUser == false) {
            loginResult.setMsg("登录失败");
            loginResult.setResult(false);
        }
        return loginResult;
    }

    /**
     * 根据账号查询用户信息
     * @param username
     * @return
     */
    @RequestMapping(value = "/api/self",method = RequestMethod.GET)
    public User findUserByUsername(String username) {
        return loginAndRegService.findByUsername(username);
    }

    @RequestMapping(value = "/api/self",method = RequestMethod.PUT)
    public User updateUser(@RequestBody User user){
        return loginAndRegService.updateUser(user);
    }
}
