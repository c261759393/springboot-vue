package com.fndsoft.demonstration.dao;

import com.fndsoft.demonstration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @创建人 bob
 * @创建时间 2018/6/5
 * @描述：
 */
public interface UserRepository  extends JpaRepository<User,Long> {

    List<User> findByUsernameAndPassword(String username,String password);

}
