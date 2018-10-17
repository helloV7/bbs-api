package com.jyt.bbs.service.impl;

import com.jyt.bbs.dao.AreaMapper;
import com.jyt.bbs.model.entity.Area;
import com.jyt.bbs.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AreaServiceImpl implements AreaService{
    @Autowired
    AreaMapper areaMapper;


    @Override
    public List<Area> getLevel1Area() {
        return areaMapper.listArea(null);
    }

    @Override
    public List<Area> getLevel2Area(Integer l1Id) {
        return areaMapper.listArea(l1Id);
    }
}
