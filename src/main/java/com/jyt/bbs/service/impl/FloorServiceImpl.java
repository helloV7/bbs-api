package com.jyt.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyt.bbs.dao.FloorMapper;
import com.jyt.bbs.model.dto.CustomPage;
import com.jyt.bbs.model.entity.Floor;
import com.jyt.bbs.model.entity.Post;
import com.jyt.bbs.model.entity.User;
import com.jyt.bbs.service.FloorService;
import com.jyt.bbs.service.PostService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Component
@Transactional
public class FloorServiceImpl implements FloorService{
    @Autowired
    FloorMapper floorMapper;
    @Autowired
    PostService postService;

    @Override
    public Floor addNewFloor(Floor floor) {
        Post post = postService.getPostByPostId(floor.getPostId());
        if (post==null){
            throw new RuntimeException("无此帖子");
        }
        if (!StringUtils.isEmpty(floor.getToNum())) {
            Floor frontFloor = floorMapper.getFloorByPostIdAndNum(floor.getPostId(), floor.getToNum());
            if (frontFloor == null) {
                throw new RuntimeException("无此楼层");
            }
        }

        floor.setUserId(((User) SecurityUtils.getSubject().getPrincipal()).getId());
        floor.setCreateTime(new Date());
        floorMapper.addFloor(floor);
        //TODO 信息通知


        return floor;
    }

    @Override
    public Floor updateFloor(Floor floor) {
        floorMapper.updateByPrimaryKey(floor);
        return floor;
    }

    @Override
    public Floor deleteFloor(Integer floorId) {
        Floor floor = floorMapper.selectByPrimaryKey(floorId);

        if (floor!=null){
            floor.setContent("此楼层已被删除");
        }
        floorMapper.updateByPrimaryKey(floor);
        return floor;
    }

    @Override
    public PageInfo<Floor> listFloorByPostId(Integer postId, CustomPage customPage) {

        PageHelper.startPage(customPage);
        List<Floor> floors = floorMapper.listFloorByPostIdOrderByDate(postId);
        return PageInfo.of(floors);
    }

    @Override
    public boolean haveFloor(Integer postId, Integer userId) {

        Floor floor = floorMapper.getFloorByUserIdAndPostId(userId,postId);
        return floor!=null;
    }
}
