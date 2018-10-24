package com.jyt.bbs.service;

import com.github.pagehelper.PageInfo;
import com.jyt.bbs.model.dto.CustomPage;
import com.jyt.bbs.model.entity.Message;
import io.swagger.models.auth.In;

import java.util.List;

public interface MessageService {


    void sendMessage(Integer fromId,Integer toId,String message,String type);

    int getUnreadMessageCount(Integer userId);

    List<Message> listUnReadMessage(Integer userId, Integer friendId, CustomPage customPage);

    List<Message> listHistoryMessage(Integer userId, Integer friendId, CustomPage customPage);

    void setMessageStateToRead(Integer messageId);
}
