package com.jyt.bbs.controller.front;

import com.jyt.bbs.model.entity.Post;
import com.jyt.bbs.model.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "帖子控制器")
@RestController
@RequestMapping(value = "/post")
public class PostController {

    @ApiOperation(value = "发帖")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public R addPost(Post post){



        return R.ok();
    }

    @ApiOperation(value = "回帖")
    @RequestMapping(value = "/")
    public R addFloor(){

        return R.ok();
    }
}
