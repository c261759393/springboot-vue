package com.fndsoft.demonstration.controller;

import com.fndsoft.demonstration.entity.Staff;
import com.fndsoft.demonstration.model.PageList;
import com.fndsoft.demonstration.service.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @创建人 bob
 * @创建时间 2018/6/7
 * @描述：
 */
@CrossOrigin(origins = "*", maxAge = 3600)      //跨域
@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StaffService staffService;

    /**
     * 查询列表
     * @param pageNum
     * @param likeName
     * @param likeProvince
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public PageList<Staff> findAllStaff(Integer pageNum, String likeName, String likeProvince) {
        String name = "%" + likeName + "%";
        String province = "%" + likeProvince + "%";
        PageList<Staff> pageList = new PageList();
        List<Staff> staff = staffService.findAll(name, province);
        int totalCount = staff.size();
        if (totalCount > 0) {
            //分页大小为5
            int pageSize = 5;
            List<Staff> staffList;
            //分页赋值
            if (totalCount % pageSize == 0) {
                pageList.setTotalPages(totalCount / pageSize);
                staffList = staff.subList((pageNum - 1) * pageSize, pageNum * pageSize);
            } else {
                pageList.setTotalPages(totalCount / pageSize + 1);
                if (pageNum <= totalCount / pageSize) {
                    staffList = staff.subList((pageNum - 1) * pageSize, pageNum * pageSize);
                } else {
                    staffList = staff.subList((pageNum - 1) * pageSize, totalCount);
                }
            }
            pageList.setList(staffList);
            pageList.setTotalCount(totalCount);
            return pageList;
        } else {
            pageList.setTotalPages(1);
            pageList.setList(staff);
            pageList.setTotalPages(1);
            return pageList;
        }

    }

    /**
     * 根据ID查询员工信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Staff findById(@PathVariable("id") Long id) {
        return staffService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Staff addStaff(@RequestBody Staff staff) {
        Staff staff1 = staffService.addStaff(staff);
        logger.info("增加员工成功");
        return staff1;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Staff updateStaff(@RequestBody Staff staff) {
        return staffService.updateStaff(staff);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Staff deleteStaff(@PathVariable("id") Long id) {
        return staffService.deleteStaff(id);
    }
}
