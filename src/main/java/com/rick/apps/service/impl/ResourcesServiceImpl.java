package com.rick.apps.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rick.apps.mapper.ExtResourcesMapper;
import com.rick.apps.service.IResourcesService;
import com.rick.generator.entity.Resources;
import com.rick.generator.entity.ResourcesExample;
import com.rick.generator.mapper.ResourcesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Desc :  资源service
 * User : RICK
 * Time : 2017/9/1 13:23
  */
@Service
public class ResourcesServiceImpl implements IResourcesService {

    @Autowired
    private ResourcesMapper resourcesMapper;

    @Autowired
    private ExtResourcesMapper extResourcesMapper;

    @Override
    public PageInfo<Resources> selectByPage(Resources resources, int start, int length) {
        int page = start / length + 1;
        ResourcesExample example = new ResourcesExample();
        PageHelper.startPage(page, length);
        List<Resources> resourcesList = resourcesMapper.selectByExample(example);
        return new PageInfo<>(resourcesList);
    }

    @Override
    public List<Resources> queryAll() {
        ResourcesExample example = new ResourcesExample();
        List<Resources> resourcesList = resourcesMapper.selectByExample(example);
        return resourcesList;
    }

    @Override
    @Cacheable(cacheNames="resources",key="#map['userId'].toString() + #map['type']")
    public List<Resources> loadUserResources(Map<String, Object> map) {
        return extResourcesMapper.loadUserResources(map);
    }

    @Override
    public List<Resources> queryResourcesListWithSelected(Integer rid) {
        return extResourcesMapper.queryResourcesListWithSelected(rid);
    }

    @Override
    public void save(Resources resources) {
        resourcesMapper.insertSelective(resources);
    }

    @Override
    public void delete(Integer id) {
        resourcesMapper.deleteByPrimaryKey(id);
    }
}
