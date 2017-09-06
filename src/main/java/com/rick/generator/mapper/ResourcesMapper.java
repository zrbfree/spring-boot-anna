package com.rick.generator.mapper;

import com.rick.generator.entity.Resources;
import com.rick.generator.entity.ResourcesExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ResourcesMapper {
    @SelectProvider(type=ResourcesSqlProvider.class, method="countByExample")
    int countByExample(ResourcesExample example);

    @DeleteProvider(type=ResourcesSqlProvider.class, method="deleteByExample")
    int deleteByExample(ResourcesExample example);

    @Delete({
        "delete from t_resources",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_resources (name, res_url, ",
        "type, parent_id, ",
        "sort)",
        "values (#{name,jdbcType=VARCHAR}, #{resUrl,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=INTEGER}, #{parentId,jdbcType=INTEGER}, ",
        "#{sort,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(Resources record);

    @InsertProvider(type=ResourcesSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(Resources record);

    @SelectProvider(type=ResourcesSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="res_url", property="resUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER)
    })
    List<Resources> selectByExample(ResourcesExample example);

    @Select({
        "select",
        "id, name, res_url, type, parent_id, sort",
        "from t_resources",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="res_url", property="resUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER)
    })
    Resources selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ResourcesSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Resources record, @Param("example") ResourcesExample example);

    @UpdateProvider(type=ResourcesSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Resources record, @Param("example") ResourcesExample example);

    @UpdateProvider(type=ResourcesSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Resources record);

    @Update({
        "update t_resources",
        "set name = #{name,jdbcType=VARCHAR},",
          "res_url = #{resUrl,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=INTEGER},",
          "parent_id = #{parentId,jdbcType=INTEGER},",
          "sort = #{sort,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Resources record);
}