package com.jyt.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.jyt.bbs.dao.MessageMapper;
import com.jyt.bbs.model.dto.CustomPage;
import com.jyt.bbs.model.entity.Message;
import com.jyt.bbs.service.MessageService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Transactional
public class MessageServiceImpl implements MessageService{
    @Autowired
    MessageMapper messageMapper;

    /**
     *
     * @param fromId
     * @param toId
     * @param message
     * @param type 0、禁言。1、解禁言。2、购买。3、举报别人帖子的处理。4、自己的帖子或者楼层被删除的消息。5、私信
     */
    @Override
    public void sendMessage(Integer fromId, Integer toId, String message,String type) {

        Message msg = new Message();
        msg.setFromId(fromId);
        msg.setToId(toId);
        msg.setCreateTime(new Date());
        msg.setTime(new Date());
        msg.setState(0);
        msg.setType(type);
        msg.setMessage(message);

        messageMapper.insert(msg);
    }

    public int getUnreadMessageCount(Integer userId){

        return messageMapper.getUnReadMessageCount(userId);
    }

    @Override
    public List<Message> listUnReadMessage(Integer userId, Integer friendId, CustomPage customPage) {
        PageHelper.startPage(customPage);
        List<Message> messages =  messageMapper.listUnReadMessage(userId,friendId);

        List<Integer> ids = new ArrayList();
        for (Message message:
             messages) {
            message.setState(1);
            ids.add(message.getId());
        }
        if (ids.size()!=0)
            messageMapper.setMessageStateToRead(ids);
        return messages;
    }

    @Override
    public List<Message> listHistoryMessage(Integer userId, Integer friendId, CustomPage customPage) {
        PageHelper.startPage(customPage);
        return messageMapper.listHistoryMessage(userId,friendId);
    }

    @Override
    public void setMessageStateToRead(Integer messageId) {
        Message message = messageMapper.selectByPrimaryKey(messageId);
        if (message==null){
            return;
        }
        message.setState(1);
        messageMapper.updateByPrimaryKey(message);
    }


}
