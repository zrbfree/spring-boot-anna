package com.rick.apps.entity;

import java.io.Serializable;

public class ParamUserRole implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer userId;

    private String roleId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "ParamUserRole{" +
                "userId=" + userId +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}