package com.gy.findcase.findcaseapi.controller;

import com.gy.findcase.findcaseapi.annotation.CurrentUser;
import com.gy.findcase.findcaseapi.entity.Problem;
import com.gy.findcase.findcaseapi.entity.User;
import com.gy.findcase.findcaseapi.service.ProblemService;
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
 * @date 2018/8/16 11:43
 * @email 1984629668@qq.com
 * @description
 */
@RestController
@RequestMapping("/problem")
@Api(value = "问题管理")
public class ProblemController {
    private final ProblemService problemService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @ApiOperation(value = "添加问题")
    @PostMapping
    public SimpleResponse add(@RequestBody Problem problem, @CurrentUser User user) {
        problem.setUser(user);
        this.problemService.save(problem);
        return simpleResponse(200);
    }

    @ApiOperation(value = "查询所有的问题")
    @GetMapping
    public SimpleResponse query(@CurrentUser User user) {
        Items<Problem> query = this.problemService.query();
        List<Problem> items = query.getItems();
        return simpleResponse(200, items);
    }

    @ApiOperation(value = "我发布的问题")
    @GetMapping("/my")
    public SimpleResponse queryMy(@CurrentUser User user) {
        List<Problem> list = this.problemService.queryByUser(user);
        return simpleResponse(200, list);
    }
}
