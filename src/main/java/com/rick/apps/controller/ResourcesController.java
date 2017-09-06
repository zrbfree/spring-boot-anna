package com.rick.apps.controller;

import com.github.pagehelper.PageInfo;
import com.rick.apps.service.IResourcesService;
import com.rick.common.shiro.ShiroService;
import com.rick.generator.entity.Resources;
import org.apache.shiro.SecurityUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Desc :  资源控制器
 * User : RICK
 * Time : 2017/9/1 15:04
 */
@RestController
@RequestMapping("/resources")
public class ResourcesController {
    @Resource
    private IResourcesService resourcesService;
    @Resource
    private ShiroService      shiroService;

    /**
     * Desc :  分页查询资源信息
     * User : RICK
     * Time : 2017/9/1 15:06
     */

    @RequestMapping
    public Map<String, Object> getAll(Resources resources, String draw,
                                      @RequestParam(required = false, defaultValue = "1") int start,
                                      @RequestParam(required = false, defaultValue = "10") int length) {
        Map<String, Object> map = new HashMap<>();
        PageInfo<Resources> pageInfo = resourcesService.selectByPage(resources, start, length);
        System.out.println("pageInfo.getTotal():" + pageInfo.getTotal());
        map.put("draw", draw);
        map.put("recordsTotal", pageInfo.getTotal());
        map.put("recordsFiltered", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }


    @RequestMapping("/resourcesWithSelected")
    public List<Resources> resourcesWithSelected(Integer rid) {
        return resourcesService.queryResourcesListWithSelected(rid);
    }


    @RequestMapping("/loadMenu")
    public List<Resources> loadMenu() {
        Map<String, Object> map = new HashMap<>();
        Integer userid = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userSessionId");
        map.put("type", 1);
        map.put("userId", userid);
        List<Resources> resourcesList = resourcesService.loadUserResources(map);
        return resourcesList;
    }

    @CacheEvict(cacheNames = "resources", allEntries = true)
    @RequestMapping(value = "/add")
    public String add(Resources resources) {
        try {
            resourcesService.save(resources);
            //更新权限
            shiroService.updatePermission();
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @CacheEvict(cacheNames = "resources", allEntries = true)
    @RequestMapping(value = "/delete")
    public String delete(Integer id) {
        try {
            resourcesService.delete(id);
            //更新权限
            shiroService.updatePermission();
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
