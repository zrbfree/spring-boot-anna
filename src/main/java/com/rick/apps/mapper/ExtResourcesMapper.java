package com.rick.apps.mapper;

import com.rick.generator.entity.Resources;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface ExtResourcesMapper {

    @SelectProvider(type = ExtResourcesSqlProvider.class, method = "loadUserResources")
    public List<Resources> loadUserResources(Map<String, Object> map);

    @SelectProvider(type = ExtResourcesSqlProvider.class, method = "queryResourcesListWithSelected")
    public List<Resources> queryResourcesListWithSelected(Integer rid);
}
