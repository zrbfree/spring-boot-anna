package com.rick.apps.mapper;

public class ExtRoleSqlProvider {

    public String queryRoleListWithSelected(Integer id){
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT r.id,r role_desc as r.roleDesc,");
        sql.append(" (CASE WHEN (SELECT ur.role_id as roleId FROM t_user_role ur WHERE ur.user_id=").append(id);
        sql.append(" AND ur.role_id = r.id) THEN 1 ELSE 0 END) AS selected");
        sql.append(" FROM t_role r");
        return sql.toString();
    }
}
