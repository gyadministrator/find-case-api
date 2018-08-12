package com.gy.findcase.findcaseapi.controller;

import com.gy.findcase.findcaseapi.annotation.CurrentUser;
import com.gy.findcase.findcaseapi.entity.Project;
import com.gy.findcase.findcaseapi.entity.User;
import com.gy.findcase.findcaseapi.service.ProjectService;
import com.gy.findcase.findcaseapi.service.support.OrderType;
import com.gy.findcase.findcaseapi.service.support.PageQuery;
import com.gy.findcase.findcaseapi.utils.response.PageAndSortResponse;
import com.gy.findcase.findcaseapi.utils.response.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gy.findcase.findcaseapi.utils.response.HttpResponseAndStatus.pageAndSortResponse;
import static com.gy.findcase.findcaseapi.utils.response.HttpResponseAndStatus.simpleResponse;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/8/12 12:58
 * @email 1984629668@qq.com
 * @description
 */
@RestController
@RequestMapping("/project")
@Api(value = "项目管理")
public class ProjectController {
    private final ProjectService projectService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @ApiOperation(value = "添加项目")
    @PostMapping
    public SimpleResponse add(@RequestBody Project project, @CurrentUser User user) {
        logger.info("添加项目----->" + project.toString());
        project.setUser(user);
        this.projectService.save(project);
        return simpleResponse(200);
    }

    @ApiOperation(value = "分页查询项目数据")
    @GetMapping("/{currentPage}/{pageSize}")
    public PageAndSortResponse query(@PathVariable("currentPage") Integer currentPage, @PathVariable("pageSize") Integer pageSize, @CurrentUser User user) {
        PageQuery<Project> query = this.projectService.query(currentPage, pageSize, OrderType.DESC, "name");
        return pageAndSortResponse(200, query);
    }


    @ApiOperation(value = "分页查询项目数据通过类型")
    @GetMapping("/{type}")
    public SimpleResponse queryByType(@PathVariable("type") Integer type, @CurrentUser User user) {
        List<Project> projects = this.projectService.queryProjectByType(type);
        return simpleResponse(200, projects);
    }

    @ApiOperation(value = "我发布的项目")
    @GetMapping("/release")
    public SimpleResponse queryById( @CurrentUser User user) {
        List<Project> projects = this.projectService.queryProjectByUserId(user);
        return simpleResponse(200, projects);
    }
}
