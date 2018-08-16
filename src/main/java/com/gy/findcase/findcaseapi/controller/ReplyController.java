package com.gy.findcase.findcaseapi.controller;

import com.gy.findcase.findcaseapi.annotation.CurrentUser;
import com.gy.findcase.findcaseapi.entity.Problem;
import com.gy.findcase.findcaseapi.entity.Reply;
import com.gy.findcase.findcaseapi.entity.User;
import com.gy.findcase.findcaseapi.service.ReplyService;
import com.gy.findcase.findcaseapi.service.support.Items;
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

    @ApiOperation(value = "添加问题")
    @PostMapping
    public SimpleResponse add(@RequestBody Reply reply, @CurrentUser User user) {
        this.replyService.save(reply);
        return simpleResponse(200);
    }

    @ApiOperation(value = "查询所有的问题")
    @PostMapping("/problem")
    public SimpleResponse query(@RequestBody Problem problem, @CurrentUser User user) {
        List<Reply> query = this.replyService.queryByProblem(problem);
        return simpleResponse(200, query);
    }
}
