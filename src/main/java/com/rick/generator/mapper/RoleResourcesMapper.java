package com.rick.generator.mapper;

import com.rick.generator.entity.RoleResources;
import com.rick.generator.entity.RoleResourcesExample;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface RoleResourcesMapper {
    @SelectProvider(type=RoleResourcesSqlProvider.class, method="countByExample")
    int countByExample(RoleResourcesExample example);

    @DeleteProvider(type=RoleResourcesSqlProvider.class, method="deleteByExample")
    int deleteByExample(RoleResourcesExample example);

    @Insert({
        "insert into t_role_resources (role_id, resources_id)",
        "values (#{roleId,jdbcType=INTEGER}, #{resourcesId,jdbcType=INTEGER})"
    })
    int insert(RoleResources record);

    @InsertProvider(type=RoleResourcesSqlProvider.class, method="insertSelective")
    int insertSelective(RoleResources record);

    @SelectProvider(type=RoleResourcesSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER),
        @Result(column="resources_id", property="resourcesId", jdbcType=JdbcType.INTEGER)
    })
    List<RoleResources> selectByExample(RoleResourcesExample example);

    @UpdateProvider(type=RoleResourcesSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RoleResources record, @Param("example") RoleResourcesExample example);

    @UpdateProvider(type=RoleResourcesSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RoleResources record, @Param("example") RoleResourcesExample example);
}