package com.fndsoft.demonstration.service.impl;

import com.fndsoft.demonstration.dao.StaffRepository;
import com.fndsoft.demonstration.entity.Staff;
import com.fndsoft.demonstration.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @创建人 bob
 * @创建时间 2018/6/7
 * @描述：
 */
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffRepository staffRepository;

    @Override
    public List<Staff> findAll(String name,String province) {
        return staffRepository.findAll(name,province);
    }

    @Override
    public Staff findById(Long id) {
        return staffRepository.findById(id).get();
    }

    @Override
    public Staff addStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Staff updateStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Staff deleteStaff(Long id) {
        Staff staff = staffRepository.findById(id).get();
        staffRepository.delete(staff);
        return staff;
    }


}
