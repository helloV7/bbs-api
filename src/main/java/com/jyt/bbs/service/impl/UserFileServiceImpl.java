package com.jyt.bbs.service.impl;

import com.jyt.bbs.dao.UserFileMapper;
import com.jyt.bbs.model.entity.Post;
import com.jyt.bbs.model.entity.ScoreWater;
import com.jyt.bbs.model.entity.User;
import com.jyt.bbs.model.entity.UserFile;
import com.jyt.bbs.service.PostService;
import com.jyt.bbs.service.ScoreRecordService;
import com.jyt.bbs.service.UserFileService;
import com.jyt.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;

@Transactional
@Component
public class UserFileServiceImpl implements UserFileService {
    @Autowired
    UserFileMapper userFileMapper;
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;
    @Autowired
    ScoreRecordService scoreRecordService;

    @Override
    public boolean haveFileRecord(Integer userId, Integer postId) {
        return userFileMapper.getUserFileByUserIdAndPostId(userId,postId)!=null;
    }

    @Override
    public UserFile buyFile(Integer userId, Integer postId) {

        Post post = postService.getPostByPostId(postId);

        if(StringUtils.isEmpty(post.getFileUrl()) || post.getScore()==null || post.getScore().doubleValue()<=0){
            throw new RuntimeException("无附件可购买");
        }

        if (haveFileRecord(userId,postId)){
            throw new RuntimeException("请勿重复购买");
        }

        User user = userService.getUserById(userId);
        if (user.getScore().compareTo(post.getScore())==-1){
            throw new RuntimeException("积分不足");
        }

        //用户消费积分
        {
            user.setScore(user.getScore().subtract(post.getScore()));
            ScoreWater scoreWater = new ScoreWater();
            scoreWater.setUserId(userId);
            scoreWater.setScore(post.getScore());
            scoreWater.setContent("购买" + post.getTitle() + "内附件");
            scoreWater.setType(0);
            scoreRecordService.addRecord(scoreWater);

            userService.updateUserBaseInfo(user);
        }
        //楼主获取积分
        {
            User postUser = userService.getUserById(post.getUserId());
            postUser.setScore(postUser.getScore().add(post.getScore()));
            ScoreWater scoreWater = new ScoreWater();
            scoreWater.setUserId(post.getUserId());
            scoreWater.setScore(post.getScore());
            scoreWater.setContent("用户"+user.getNickname()+"购买" + post.getTitle() + "内附件");
            scoreWater.setType(1);
            scoreRecordService.addRecord(scoreWater);

            userService.updateUserBaseInfo(postUser);
        }

        UserFile userFile = new UserFile();
        userFile.setCreateTime(new Date());
        userFile.setPostId(post.getId());
        userFile.setScore(post.getScore());
        userFile.setUserId(userId);

        userFileMapper.insert(userFile);

        return userFile;
    }
}
