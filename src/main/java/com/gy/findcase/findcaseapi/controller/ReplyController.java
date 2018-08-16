package com.gy.findcase.findcaseapi.controller;

import com.gy.findcase.findcaseapi.service.ReplyService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/8/16 11:44
 * @email 1984629668@qq.com
 * @description
 */
@RestController
@RequestMapping("/reply")
@Api(value = "评论管理")
public class ReplyController {
    private final ReplyService replyService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }
}
