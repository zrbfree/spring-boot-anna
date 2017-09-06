package com.rick.apps.mapper;

import java.util.Map;

public class ExtResourcesSqlProvider {

    public String loadUserResources(Map map){
        StringBuilder sql = new StringBuilder();
        Integer userId = (Integer) map.get("userId");
        sql.append(" SELECT re.id,re.name,re.parent_id as parentId,re.res_url as resUrl");
        sql.append(" FROM t_resources re LEFT JOIN t_role_resources rr  ON re.id = rr.resources_id");
        sql.append(" LEFT JOIN t_user_role ur ON rr.role_id =ur.role_id");
        sql.append(" WHERE ur.user_id=").append(userId);

        if (map.containsKey("type")){
            sql.append(" AND re.type=").append(map.get("type"));
        }
        sql.append(" GROUP BY re.id ORDER BY re.sort ASC");
        return sql.toString();
    }


    public String queryResourcesListWithSelected(Integer rid){
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT re.id,re.name,re.parent_id,re.res_url,re.type,");
        sql.append(" (CASE WHEN EXISTS(SELECT 1 FROM t_role_resources rr WHERE rr.resources_id=re.id AND rr.role_id=").append(rid).append(")");
        sql.append(" THEN 'true' ELSE 'false' END) AS checked");
        sql.append(" FROM t_resources re");
        sql.append(" WHERE re.parent_id !=0");
        sql.append(" ORDER BY re.sort ASC");
        return sql.toString();
    }
}
