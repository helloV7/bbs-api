package com.jyt.bbs.service;

import com.github.pagehelper.PageInfo;
import com.jyt.bbs.model.dto.CustomPage;
import com.jyt.bbs.model.entity.Floor;

public interface FloorService {

    Floor addNewFloor(Floor floor);

    Floor updateFloor(Floor floor);

    Floor deleteFloor(Integer floorId);

    PageInfo<Floor> listFloorByPostId(Integer postId, CustomPage CustomPage);

    boolean haveFloor(Integer postId,Integer userId);
}
