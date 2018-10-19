package com.jyt.bbs.controller.front;

import com.github.pagehelper.PageInfo;
import com.jyt.bbs.model.dto.CustomPage;
import com.jyt.bbs.model.entity.Post;
import com.jyt.bbs.model.entity.User;
import com.jyt.bbs.model.validator.AddPostValidator;
import com.jyt.bbs.model.vo.PostDetail;
import com.jyt.bbs.model.vo.PostThumb;
import com.jyt.bbs.model.vo.R;
import com.jyt.bbs.service.PostService;
import com.jyt.bbs.service.UserFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javafx.geometry.Pos;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "帖子控制器",tags = "帖子")
@RestController
@RequestMapping(value = "/post")
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    UserFileService userFileService;

    @ApiOperation(value = "发帖")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public R addPost(@Validated AddPostValidator postValidator){

        Post post = new Post();
        BeanUtils.copyProperties(postValidator,post);
        postService.addNewPost(post);

        return R.ok();
    }
    @ApiOperation(value = "修改发帖")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public R updatePost(Post post){
        if (post.getId()==null){
            return R.error().setMessage("id不能为空");
        }
        postService.updatePost(post);

        return R.ok();
    }

    @ApiOperation(value = "删除帖子")
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public R deletePost(Integer id){
        postService.delPost(id);
        return R.ok();
    }


    @ApiOperation(value = "分区帖子列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public R<PageInfo<PostThumb>> listPostByArea(Integer areaId, CustomPage CustomPage){

        PageInfo<PostThumb>  postPageInfo = postService.listPostByAreaId(areaId,null,null,CustomPage);

        return R.ok().setData(postPageInfo);
    }

    @ApiOperation(value = "帖子搜索")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "filterTime",value = "时间筛选类型 null全部 1今天 2昨天 3前三天",required = false,allowableValues = "[null,1,2]",defaultValue = "null" ),
            @ApiImplicitParam(name = "keyword",value = "模糊查找 标题",required = false,defaultValue = "null" )
    })
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public R<PageInfo<PostThumb>> search(Integer areaId, @RequestParam(required = false) Integer filterTime, @RequestParam(required = false) String keyword, CustomPage CustomPage){

        PageInfo pageInfo = postService.listPostByAreaId(areaId,filterTime,keyword,CustomPage);

        return R.ok().setData(pageInfo);
    }

    @ApiOperation(value = "帖子详情")
    @RequestMapping(value = "",method = RequestMethod.GET)
    public R<PostDetail> postDetail(Integer postId){
        Integer userId = null;
        if (SecurityUtils.getSubject().getPrincipal()!=null){
            userId = ((User) SecurityUtils.getSubject().getPrincipal()).getId();
        }

        PostDetail postDetail = postService.getPostDetailByPostId(postId,userId);

        return R.ok().setData(postDetail);
    }

    @ApiOperation(value = "购买附件")
    @RequestMapping(value = "/buy",method = RequestMethod.POST)
    public R buyFile(Integer postId){

        Integer userId = ((User) SecurityUtils.getSubject().getPrincipal()).getId();
        userFileService.buyFile(userId,postId);

        return R.ok().setMessage("购买成功");
    }

    @ApiOperation(value = "获取用户发过的帖子")
    @RequestMapping(value = "/list/user")
    public R<PageInfo<PostThumb>> userPostList(@RequestParam(required = true) Integer userId,CustomPage customPage){

        return  R.ok().setData(postService.listPostThumbByUserId(userId,customPage));
    }
}
