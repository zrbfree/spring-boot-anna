package com.rick.apps.controller;

import com.github.pagehelper.PageInfo;
import com.rick.apps.entity.ParamRoleResources;
import com.rick.apps.service.IRoleResourcesService;
import com.rick.apps.service.IRoleService;
import com.rick.generator.entity.Role;
import com.rick.generator.entity.RoleResources;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Desc :  角色控制器
 * User : RICK
 * Time : 2017/9/1 15:10
 */
@RestController
@RequestMapping("/roles")
public class RoleController {

    @Resource
    private IRoleService          roleService;
    @Resource
    private IRoleResourcesService roleResourcesService;

    @RequestMapping
    public Map<String, Object> getAll(Role role, String draw,
                                      @RequestParam(required = false, defaultValue = "1") int start,
                                      @RequestParam(required = false, defaultValue = "10") int length) {
        Map<String, Object> map = new HashMap<>();
        PageInfo<Role> pageInfo = roleService.selectByPage(role, start, length);
        map.put("draw", draw);
        map.put("recordsTotal", pageInfo.getTotal());
        map.put("recordsFiltered", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }


    @RequestMapping("/rolesWithSelected")
    public List<Role> rolesWithSelected(Integer uid) {
        return roleService.queryRoleListWithSelected(uid);
    }

    //分配角色
    @RequestMapping("/saveRoleResources")
    public String saveRoleResources(ParamRoleResources roleResources) {
        if (StringUtils.isEmpty(roleResources.getRoleId()))
            return "error";
        try {
            roleResourcesService.addRoleResources(roleResources);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/add")
    public String add(Role role) {
        try {
            roleService.save(role);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/delete")
    public String delete(Integer id) {
        try {
            roleService.delRole(id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }


}
