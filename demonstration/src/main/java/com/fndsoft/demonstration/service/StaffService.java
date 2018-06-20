package com.fndsoft.demonstration.service;

import com.fndsoft.demonstration.entity.Staff;


import java.util.List;

/**
 * @创建人 bob
 * @创建时间 2018/6/7
 * @描述：
 */
public interface StaffService {

    /**
     * 员工列表
     * @param name
     * @param province
     * @return
     */
    List<Staff> findAll(String name, String province);

    Staff findById(Long id);

    Staff addStaff(Staff staff);

    Staff updateStaff(Staff staff);

    Staff deleteStaff(Long id);

}
