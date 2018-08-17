package com.wat.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: chuangwang8
 * @Date: 2018-08-16 16:31
 * @Description:
 */
@RequestMapping("/index")
@Controller
public class indexController {

    @RequestMapping("")
    public String index(){

       return "/index";
    }


}
