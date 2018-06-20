package com.fndsoft.demonstration.service.impl;

import com.fndsoft.demonstration.dao.UserRepository;
import com.fndsoft.demonstration.entity.User;
import com.fndsoft.demonstration.service.LoginAndRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @创建人 bob
 * @创建时间 2018/6/5
 * @描述：
 */
@Service
public class LoginAndRegisterServiceImpl implements LoginAndRegisterService {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean verifyUser(User user) {
        List<User> userList = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        //若为零或空则说明没有找到对应的账号密码
        if (userList == null || userList.size() == 0) {
            return false;
        }else {
            return true;
        }
    }
}
