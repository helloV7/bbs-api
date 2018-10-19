package com.jyt.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyt.bbs.dao.PostMapper;
import com.jyt.bbs.model.dto.CustomPage;
import com.jyt.bbs.model.entity.Post;
import com.jyt.bbs.model.entity.User;
import com.jyt.bbs.model.vo.PostDetail;
import com.jyt.bbs.model.vo.PostThumb;
import com.jyt.bbs.service.FloorService;
import com.jyt.bbs.service.PostService;
import com.jyt.bbs.service.UserFileService;
import com.jyt.bbs.util.DateUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Component
@Transactional
public class PostServiceImpl implements PostService {
    @Autowired
    PostMapper postMapper;
    @Autowired
    FloorService floorService;
    @Autowired
    UserFileService userFileService;

    @Override
    public Post addNewPost(Post post) {
        if ("1".equals(post.getType())){
            if (StringUtils.isEmpty(post.getFileUrl())){
                throw new RuntimeException("分享链接不能为空");
            }
        }
        if (post.getScore()!=null && post.getScore().doubleValue()<0){
            throw new RuntimeException("分享需要的积分不能小于0");
        }
        post.setUserId(((User)SecurityUtils.getSubject().getPrincipal()).getId());
        post.setCreateTime(new Date());
        post.setPerfect(0);
        post.setOverhead(0);
        post.setState(0);
        postMapper.insert(post);
        return post;
    }

    @Override
    public Post updatePost(Post post) {

        postMapper.updateByPrimaryKey(post);
        return post;
    }

    //列表不返回 内容
    @Override
    public PageInfo<PostThumb> listPostByAreaId(Integer areaId, Integer filterTime, String keyword, CustomPage CustomPage) {

        Date filterDate = null;

        if (filterTime!=null) {
            if (filterTime == 1) {
                filterDate = DateUtils.getDayBegin();
            } else if (filterTime == 2) {
                filterDate = DateUtils.getDayStartTime(DateUtils.getFrontDay(new Date(), 1));
            } else if (filterTime == 3) {
                filterDate = DateUtils.getDayStartTime(DateUtils.getFrontDay(new Date(), 3));
            }
        }
        PageHelper.startPage(CustomPage);
        List<PostThumb> postList = postMapper.listPostByAreaIdOrderByDate(areaId,filterDate,keyword);
        return PageInfo.of(postList);
    }

    @Override
    public Post delPost(Integer id) {

        Integer userId = ((User) SecurityUtils.getSubject().getPrincipal()).getId();


        Post post = getPostByPostId(id);
        //TODO 判断管理员
        if (post.getUserId()!=null && post.getUserId().intValue()!=userId.intValue()){
            throw new RuntimeException("无权删除");
        }

        post.setState(1);
        postMapper.updateByPrimaryKey(post);
        return post;
    }

    @Override
    public Post getPostByPostId(Integer id) {
        Post post =  postMapper.selectByPrimaryKey(id);
        if (post==null){
            throw new RuntimeException("帖子不存在");
        }
        return post;
    }

    public PostDetail getPostDetailByPostId(Integer postId,Integer userId){
        PostDetail postDetail= postMapper.getPostDetail(postId);
        if (postDetail==null){
            throw new RuntimeException("帖子不存在");
        }

        if (postDetail.getScore()!=null && postDetail.getScore().doubleValue() != 0 && !StringUtils.isEmpty(postDetail.getFileUrl())) {
            if (postDetail.getSee()!=null && 0==postDetail.getSee()){
                postDetail.setShowFile(true);
            }

            if (userId!=null) {
                if (postDetail.getSee()!=null && 1==postDetail.getSee()) {//回复可见
                    if (!floorService.haveFloor(postId, userId)) {
                        postDetail.setShowFile(true);
                    }
                }else {
                    if (userFileService.haveFileRecord(userId, postId)) {
                        postDetail.setCanDownload(true);
                    }
                }
            }
        }

        //TODO 管理员 判断


        return postDetail;
    }

    @Override
    public PageInfo<PostThumb> listPostThumbByUserId(Integer userId, CustomPage customPage) {

        PageHelper.startPage(customPage);
        List postThumbs = postMapper.listPostThumbByUserId(userId);
        return PageInfo.of(postThumbs);
    }


}
