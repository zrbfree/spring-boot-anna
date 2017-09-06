package com.rick.apps.service;

import com.github.pagehelper.PageInfo;
import com.rick.generator.entity.Resources;

import java.util.List;
import java.util.Map;

public interface IResourcesService {

    PageInfo<Resources> selectByPage(Resources resources, int start, int length);

    List<Resources> queryAll();

    List<Resources> loadUserResources(Map<String,Object> map);

    public List<Resources> queryResourcesListWithSelected(Integer rid);

    void save(Resources resources);

    void delete(Integer id);
}
