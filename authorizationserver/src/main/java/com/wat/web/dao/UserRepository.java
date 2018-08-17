package com.wat.web.dao;


import com.wat.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: chuangwang8
 * @Date: 2018-08-17 16:14
 * @Description:
 */
@Repository
public interface  UserRepository extends JpaRepository<User,Long> {

}
