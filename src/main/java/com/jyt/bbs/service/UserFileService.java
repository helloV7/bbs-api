package com.jyt.bbs.service;

import com.jyt.bbs.model.entity.UserFile;

public interface UserFileService {

    boolean haveFileRecord(Integer userId,Integer postId);

    UserFile buyFile(Integer userId,Integer postId);
}
