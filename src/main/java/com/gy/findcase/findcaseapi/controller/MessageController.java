package com.gy.findcase.findcaseapi.controller;

import com.gy.findcase.findcaseapi.annotation.CurrentUser;
import com.gy.findcase.findcaseapi.entity.Message;
import com.gy.findcase.findcaseapi.entity.User;
import com.gy.findcase.findcaseapi.service.MessageService;
import com.gy.findcase.findcaseapi.utils.response.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gy.findcase.findcaseapi.utils.response.HttpResponseAndStatus.simpleResponse;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/8/20 11:37
 * @email 1984629668@qq.com
 * @description
 */
@RestController
@RequestMapping("/message")
@Api(value = "消息管理")
public class MessageController {
    private final MessageService messageService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @ApiOperation(value = "添加消息")
    @PostMapping
    public SimpleResponse add(@RequestBody Message message) {
        this.messageService.save(message);
        return simpleResponse(200);
    }

    @ApiOperation(value = "通过类型查询消息")
    @GetMapping("/{type}")
    public SimpleResponse query(@PathVariable("type") Integer type, @CurrentUser User user) {
        List<Message> messages = this.messageService.queryByType(type);
        return simpleResponse(200, messages);
    }

    @ApiOperation(value = "查询消息")
    @GetMapping
    public SimpleResponse queryAll(@CurrentUser User user) {
        List<Message> messages = this.messageService.query().getItems();
        return simpleResponse(200, messages);
    }
}
