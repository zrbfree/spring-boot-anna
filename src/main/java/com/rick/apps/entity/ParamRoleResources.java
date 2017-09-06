package com.rick.apps.entity;

import java.io.Serializable;

public class ParamRoleResources implements Serializable{

    private Integer roleId;

    private String resourcesId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(String resourcesId) {
        this.resourcesId = resourcesId;
    }

    @Override
    public String toString() {
        return "ParamRoleResources{" +
                "roleId=" + roleId +
                ", resourcesId='" + resourcesId + '\'' +
                '}';
    }
}
