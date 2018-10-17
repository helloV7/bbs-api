package com.jyt.bbs.controller.front;

import com.jyt.bbs.model.entity.Area;
import com.jyt.bbs.model.vo.R;
import com.jyt.bbs.service.AreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "板块控制器")
@RequestMapping(value = "/area")
@RestController
public class AreaController {
    @Autowired
    AreaService areaService;

    @ApiOperation(value = "获取分区板块")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public R<List<Area>> getFirstLevelArea(@RequestParam(required = false) Integer parentId){

        List<Area>  areas = areaService.getLevel2Area(parentId);

        return R.ok().setData(areas);
    }

}
