package com.wat.web.controller;

import com.alibaba.fastjson.JSON;
import com.wat.web.dao.UserRepository;
import com.wat.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: chuangwang8
 * @Date: 2018-08-17 11:37
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/getAll")
    public Object getUser() {

        User user = this.userRepository.getOne(1L);

        return JSON.toJSONString(user);
    }

}
