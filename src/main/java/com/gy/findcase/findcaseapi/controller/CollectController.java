package com.gy.findcase.findcaseapi.controller;

import com.gy.findcase.findcaseapi.annotation.CurrentUser;
import com.gy.findcase.findcaseapi.entity.Collection;
import com.gy.findcase.findcaseapi.entity.Project;
import com.gy.findcase.findcaseapi.entity.User;
import com.gy.findcase.findcaseapi.service.CollectService;
import com.gy.findcase.findcaseapi.service.support.Items;
import com.gy.findcase.findcaseapi.utils.response.ListResponse;
import com.gy.findcase.findcaseapi.utils.response.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gy.findcase.findcaseapi.utils.response.HttpResponseAndStatus.listResponse;
import static com.gy.findcase.findcaseapi.utils.response.HttpResponseAndStatus.simpleResponse;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/8/12 19:31
 * @email 1984629668@qq.com
 * @description
 */
@RestController
@RequestMapping("/collect")
@Api(value = "收藏")
public class CollectController {
    private final CollectService collectService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public CollectController(CollectService collectService) {
        this.collectService = collectService;
    }

    @ApiOperation(value = "添加收藏")
    @PostMapping
    public SimpleResponse add(@RequestBody Collection collection, @CurrentUser User user) {
        this.collectService.save(collection);
        return simpleResponse(200);
    }

    @ApiOperation(value = "分页查询项目数据")
    @GetMapping
    public ListResponse queryByType(@CurrentUser User user) {
        List<Collection> collections = this.collectService.queryByUserId(user);
        Items items = new Items();
        items.setItems(collections);
        return listResponse(200, items);
    }
}
