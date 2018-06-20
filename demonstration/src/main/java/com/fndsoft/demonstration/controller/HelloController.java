package com.fndsoft.demonstration.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @创建人 bob
 * @创建时间 2018/6/5
 * @描述：
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String getHello() {
        return "HelloWorld";
    }

}
