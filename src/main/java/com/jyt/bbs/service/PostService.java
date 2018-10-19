package com.jyt.bbs.service;

import com.github.pagehelper.PageInfo;
import com.jyt.bbs.model.dto.CustomPage;
import com.jyt.bbs.model.entity.Post;
import com.jyt.bbs.model.vo.PostDetail;
import com.jyt.bbs.model.vo.PostThumb;
import javafx.geometry.Pos;

public interface PostService {

    Post addNewPost(Post post);

    Post updatePost(Post post);

    PageInfo<PostThumb> listPostByAreaId(Integer areaId, Integer filterTime, String keyword, CustomPage CustomPage);

    Post delPost(Integer id);

    Post getPostByPostId(Integer id);

    PostDetail getPostDetailByPostId(Integer postId, Integer userId);

    PageInfo<PostThumb> listPostThumbByUserId(Integer userId, CustomPage customPage);
}
