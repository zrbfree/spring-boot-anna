package com.rick.apps.controller;

import com.github.pagehelper.PageInfo;
import com.rick.apps.entity.ParamUserRole;
import com.rick.apps.service.IUserRoleService;
import com.rick.apps.service.IUserService;
import com.rick.generator.entity.User;
import com.rick.utils.PasswordHelper;
import com.rick.utils.StringUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    private IUserService userService;

    @Resource
    private IUserRoleService userRoleService;

    //分页查询用户信息
    @RequestMapping
    public Map<String,Object> getAll(User user, String draw,
                                     @RequestParam(required = false, defaultValue = "1") int start,
                                     @RequestParam(required = false, defaultValue = "10") int length){
        Map<String,Object> map = new HashMap<>();
        PageInfo<User> pageInfo = userService.selectByPage(user, start, length);
        System.out.println("pageInfo.getTotal():"+pageInfo.getTotal());
        map.put("draw",draw);
        map.put("recordsTotal",pageInfo.getTotal());
        map.put("recordsFiltered",pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }

    /**
     * Desc :  保存用户角色
     * User : RICK 
     * Params: userRole 用户角色，此处获取的参数的角色id是以 “,” 分隔的字符串
     * Time : 2017/9/1 14:25
      */
    @RequestMapping(value = "/saveUserRoles", method = RequestMethod.POST)
    public String saveUserRoles(ParamUserRole userRole){
        if(StringUtil.isNull(userRole.getUserId())){
            return "error";
        }
        try {
            userRoleService.addUserRole(userRole);
            return "success";
        } catch(Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    /**
     * Desc :  添加用户
     * User : RICK
     * Time : 2017/9/1 14:36
      */

    @RequestMapping(value = "/add")
    public String add(User user) {
        User u = null;
        try {
            userService.selectByUsername(user.getUserName());
            if(u != null) {
                return "error";
            }
            user.setStatus(1);
            PasswordHelper passwordHelper = new PasswordHelper();
            passwordHelper.encryptPassword(user);
            userService.save(user);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/delete")
    public String delete(Integer id){
        try{
            userService.delUser(id);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

}
