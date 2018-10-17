package com.jyt.bbs.service;

import com.jyt.bbs.model.entity.Area;

import java.util.List;

public interface AreaService {

    List<Area> getLevel1Area();

    List<Area> getLevel2Area(Integer l1Id);
}
