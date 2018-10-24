package com.jyt.bbs.controller.front;

import com.github.pagehelper.PageInfo;
import com.jyt.bbs.model.dto.CustomPage;
import com.jyt.bbs.model.entity.Message;
import com.jyt.bbs.model.entity.User;
import com.jyt.bbs.model.vo.R;
import com.jyt.bbs.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "消息 聊天")
@RestController
@RequestMapping(value = "/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequiresUser
    @ApiOperation(value = "发送消息")
    @RequestMapping(value = "/send",method = RequestMethod.POST)
    public R sendMessage(@RequestParam(required = true) Integer userId,@RequestParam(required = true) String message){

        Integer selIf = ((User) SecurityUtils.getSubject().getPrincipal()).getId();

        messageService.sendMessage(selIf,userId,message,"5");

        return R.ok();
    }


    @RequiresUser
    @ApiOperation("获取未读消息数量")
    @RequestMapping(value = "/unread/count",method = RequestMethod.GET)
    public R<Integer> getUnreadMessageCount( ){
        Integer selIf = ((User) SecurityUtils.getSubject().getPrincipal()).getId();

        int count = messageService.getUnreadMessageCount(selIf);

        return R.ok().setData(count);
    }

    @RequiresUser
    @ApiOperation(value = "获取未读消息列表",notes = "获取后消息状态自动改为已读")
    @RequestMapping(value = "/unread/list",method = RequestMethod.GET)
    public R<PageInfo<Message>> listUnReadMessage( @RequestParam(required = true)Integer friendId, CustomPage customPage){
        Integer selIf = ((User) SecurityUtils.getSubject().getPrincipal()).getId();

        List<Message> messages = messageService.listUnReadMessage(selIf,friendId,customPage);

        return R.ok().setData(PageInfo.of(messages));
    }

    @RequiresUser
    @ApiOperation(value = "获取历史消息")
    @RequestMapping(value = "/history/list",method = RequestMethod.GET)
    public R<PageInfo<Message>> listHistoryMessage( @RequestParam(required = true)Integer friendId, CustomPage customPage){
        Integer selIf = ((User) SecurityUtils.getSubject().getPrincipal()).getId();

        List<Message> messages = messageService.listHistoryMessage(selIf,friendId,customPage);

        return R.ok().setData(PageInfo.of(messages));
    }

}
