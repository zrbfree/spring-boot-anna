package com.rick.apps.service.impl;

import com.rick.apps.entity.ParamRoleResources;
import com.rick.apps.service.IRoleResourcesService;
import com.rick.generator.entity.RoleResources;
import com.rick.generator.entity.RoleResourcesExample;
import com.rick.generator.mapper.RoleResourcesMapper;
import com.rick.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleResourcesServiceImpl implements IRoleResourcesService{

    @Autowired
    private RoleResourcesMapper resourcesMapper;

    @Override
    //更新权限
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    @CacheEvict(cacheNames="resources", allEntries=true)
    public void addRoleResources(ParamRoleResources roleResources) {
        //删除旧的角色权限
        RoleResourcesExample example = new RoleResourcesExample();
        RoleResourcesExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(roleResources.getRoleId());
        resourcesMapper.deleteByExample(example);
        //新增新的角色权限
        if(StringUtil.isNotNull(roleResources.getResourcesId())){
            String[] resourcesArr = roleResources.getResourcesId().split(",");
            RoleResources r = null;
            for(String resourcesId : resourcesArr){
                r = new RoleResources();
                r.setRoleId(roleResources.getRoleId());
                r.setResourcesId(Integer.parseInt(resourcesId));
                resourcesMapper.insertSelective(r);
            }
        }

        //List<Integer> userIds= userRoleMapper.findUserIdByRoleId(roleResources.getRoleid());
        //更新当前登录的用户的权限缓存
        //shiroService.clearUserAuthByUserId(userIds);
    }
}
