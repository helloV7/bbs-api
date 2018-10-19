package com.jyt.bbs.controller.front;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyt.bbs.model.dto.CustomPage;
import com.jyt.bbs.model.entity.Floor;
import com.jyt.bbs.model.validator.AddFloorValidator;
import com.jyt.bbs.model.vo.R;
import com.jyt.bbs.service.FloorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "楼层")
@RestController
@RequestMapping(value = "/floor")
public class FloorController {

    @Autowired
    FloorService floorService;

    @RequiresUser
    @ApiOperation(value = "回复帖子")
    @RequestMapping(value = "/reply",method = RequestMethod.POST)
    public R reply(@Validated @RequestBody AddFloorValidator floorValidator){


        Floor floor = new Floor();

        BeanUtils.copyProperties(floorValidator,floor);

        floorService.addNewFloor(floor);

        return R.ok();
    }

    @ApiOperation(value = "删除楼层")
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public R del(@RequestParam(required = true) Integer floorId){

        floorService.deleteFloor(floorId);

        return R.ok();
    }

    @ApiOperation(value = "帖子下的楼层")
    @RequestMapping(value = "",method = RequestMethod.GET)
    public R<PageInfo<Floor>> postFloor(@RequestParam(required = true) Integer postId, CustomPage page){

        PageInfo<Floor> floorPageInfo = floorService.listFloorByPostId(postId,page);

        return R.ok().setData(floorPageInfo);
    }
}
