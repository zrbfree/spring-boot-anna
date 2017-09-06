package com.rick.generator.mapper;

import com.rick.generator.entity.UserRole;
import com.rick.generator.entity.UserRoleExample;
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

public interface UserRoleMapper {
    @SelectProvider(type=UserRoleSqlProvider.class, method="countByExample")
    int countByExample(UserRoleExample example);

    @DeleteProvider(type=UserRoleSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserRoleExample example);

    @Insert({
        "insert into t_user_role (user_id, role_id)",
        "values (#{userId,jdbcType=INTEGER}, #{roleId,jdbcType=INTEGER})"
    })
    int insert(UserRole record);

    @InsertProvider(type=UserRoleSqlProvider.class, method="insertSelective")
    int insertSelective(UserRole record);

    @SelectProvider(type=UserRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER)
    })
    List<UserRole> selectByExample(UserRoleExample example);

    @UpdateProvider(type=UserRoleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    @UpdateProvider(type=UserRoleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleExample example);
}