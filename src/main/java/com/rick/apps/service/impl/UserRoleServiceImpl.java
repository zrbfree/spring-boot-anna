package com.rick.apps.service.impl;

import com.rick.apps.entity.ParamUserRole;
import com.rick.apps.service.IUserRoleService;
import com.rick.generator.entity.UserRole;
import com.rick.generator.entity.UserRoleExample;
import com.rick.generator.mapper.UserRoleMapper;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRoleServiceImpl implements IUserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void addUserRole(ParamUserRole userRole) {
        //删除原有的角色
        UserRoleExample example = new UserRoleExample();
        UserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userRole.getUserId());
        userRoleMapper.deleteByExample(example);
        //新增新的角色
        String[] roleIds = userRole.getRoleId().split(",");

        UserRole u = null;
        for (String roleId : roleIds){
            u = new UserRole();
            u.setUserId(userRole.getUserId());
            u.setRoleId(Integer.parseInt(roleId));
            userRoleMapper.insertSelective(u);
        }
    }
}
