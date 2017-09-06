package com.rick.apps.service;


import com.github.pagehelper.PageInfo;
import com.rick.generator.entity.User;

public interface IUserService {

    PageInfo<User> selectByPage(User user, int start, int length);

    /**
     * Desc : 通过用户名查询用户
     * User : RICK
     * Time : 2017/8/31 14:26
      */
    public User selectByUsername(String userName) throws Exception;


    void delUser(Integer userId);

    void save(User user) ;
}
