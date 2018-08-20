package com.gy.findcase.findcaseapi.controller;

import com.gy.findcase.findcaseapi.annotation.CurrentUser;
import com.gy.findcase.findcaseapi.entity.Technology;
import com.gy.findcase.findcaseapi.entity.User;
import com.gy.findcase.findcaseapi.service.TechnologyService;
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
 * @date 2018/8/20 20:24
 * @email 1984629668@qq.com
 * @description
 */
@RestController
@RequestMapping("/technology")
@Api(value = "技术管理")
public class TechnologyController {
    private final TechnologyService technologyService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @ApiOperation(value = "添加技术")
    @PostMapping
    public SimpleResponse add(@RequestBody Technology technology) {
        this.technologyService.save(technology);
        return simpleResponse(200);
    }

    @ApiOperation(value = "查询技术")
    @GetMapping
    public SimpleResponse query(@CurrentUser User user) {
        Items<Technology> query = this.technologyService.query();
        List<Technology> items = query.getItems();
        return simpleResponse(200, items);
    }

    @ApiOperation(value = "查询技术")
    @GetMapping("/{id}")
    public SimpleResponse query(@PathVariable("id") String id, @CurrentUser User user) throws Exception {
        Technology technology = this.technologyService.queryById(id);
        return simpleResponse(200, technology);
    }
}
