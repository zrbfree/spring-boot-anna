package com.rick.apps.mapper;

import com.rick.generator.entity.Role;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface ExtRoleMapper {

    @SelectProvider(type = ExtRoleSqlProvider.class, method = "queryRoleListWithSelected")
    public List<Role> queryRoleListWithSelected(Integer id);
}
