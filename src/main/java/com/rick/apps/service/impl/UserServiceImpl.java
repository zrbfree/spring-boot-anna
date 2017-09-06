package com.rick.apps.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rick.apps.service.IUserService;
import com.rick.generator.entity.User;
import com.rick.generator.entity.UserExample;
import com.rick.generator.entity.UserRoleExample;
import com.rick.generator.mapper.UserMapper;
import com.rick.generator.mapper.UserRoleMapper;
import com.rick.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public PageInfo<User> selectByPage(User user, int start, int length) {
        int page = start/length+1;
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotNull(user.getUserName())){
            criteria.andUserNameLike("%" + user.getUserName() + "%");
        }

        if(StringUtil.isNotNull(user.getId())){
            criteria.andIdEqualTo(user.getId());
        }

        if(StringUtil.isNotNull(user.getStatus())){
            criteria.andStatusEqualTo(user.getStatus());
        }

        //分页查询数据
        PageHelper.startPage(page, length);
        List<User> userList = userMapper.selectByExample(example);
        return new PageInfo<>(userList);
    }

    @Override
    public User selectByUsername(String userName) throws Exception {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<User> userList = userMapper.selectByExample(example);
        User user = null;
        if(userList != null && userList.size() > 0){
            user = userList.get(0);
        }
        return user;
    }

    @Override
    public void delUser(Integer userId) {
        //删除用户
        userMapper.deleteByPrimaryKey(userId);
        //删除用户角色表
        UserRoleExample example = new UserRoleExample();
        UserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        userRoleMapper.deleteByExample(example);
    }

    @Override
    public void save(User user) {
        userMapper.insertSelective(user);
    }
}
