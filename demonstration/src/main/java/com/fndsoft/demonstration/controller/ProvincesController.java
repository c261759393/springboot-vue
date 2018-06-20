package com.fndsoft.demonstration.controller;

import com.fndsoft.demonstration.entity.Provinces;
import com.fndsoft.demonstration.service.ProvincesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @创建人 bob
 * @创建时间 2018/6/11
 * @描述：
 */
@CrossOrigin(origins = "*", maxAge = 3600)      //跨域
@RestController
public class ProvincesController {

    @Autowired
    ProvincesService provincesService;

    @RequestMapping(value ="/api/provinces",method = RequestMethod.GET)
    public List<Provinces> findAll() {
        return provincesService.findAll();
    }

}
