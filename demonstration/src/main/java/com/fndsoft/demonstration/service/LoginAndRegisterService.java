package com.fndsoft.demonstration.service;

import com.fndsoft.demonstration.entity.User;

/**
 * @创建人 bob
 * @创建时间 2018/6/5
 * @描述：登录和注册
 */
public interface LoginAndRegisterService {

    /**
     * 登录校验
     * @param user
     * @return
     */
    public boolean verifyUser(User user);

    public User getUserByName(String name);

    public User findByUsername(String username);

    public User updateUser(User user);
}
