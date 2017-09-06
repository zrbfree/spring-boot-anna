package com.rick.generator.entity;

import java.io.Serializable;

public class RoleResources implements Serializable {
    private Integer roleId;

    private Integer resourcesId;

    private static final long serialVersionUID = 1L;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(Integer resourcesId) {
        this.resourcesId = resourcesId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", resourcesId=").append(resourcesId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}