package com.rick.apps.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rick.apps.mapper.ExtRoleMapper;
import com.rick.apps.service.IRoleService;
import com.rick.generator.entity.Role;
import com.rick.generator.entity.RoleExample;
import com.rick.generator.entity.RoleResourcesExample;
import com.rick.generator.mapper.RoleMapper;
import com.rick.generator.mapper.RoleResourcesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private ExtRoleMapper extRoleMapper;
    @Autowired
    private RoleResourcesMapper roleResourcesMapper;

    @Override
    public List<Role> queryRoleListWithSelected(Integer uid) {
        return extRoleMapper.queryRoleListWithSelected(uid);
    }

    @Override
    public PageInfo<Role> selectByPage(Role role, int start, int length) {
        int page = start / length;
        RoleExample example = new RoleExample();
        PageHelper.startPage(page, length);
        List<Role> roleList = roleMapper.selectByExample(example);
        return new PageInfo<>(roleList);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void delRole(Integer roleid) {
        //删除角色
        roleMapper.deleteByPrimaryKey(roleid);
        //删除角色资源
        RoleResourcesExample example = new RoleResourcesExample();
        RoleResourcesExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleid);
        roleResourcesMapper.deleteByExample(example);
    }

    @Override
    public void save(Role role) {
        roleMapper.insertSelective(role);
    }
}
