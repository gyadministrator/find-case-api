package com.gy.findcase.findcaseapi.service;

import com.gy.findcase.findcaseapi.entity.Project;
import com.gy.findcase.findcaseapi.entity.User;

import java.util.List;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/8/12 12:52
 * @email 1984629668@qq.com
 * @description
 */
public interface ProjectService extends BaseService<Project, String> {
    /**
     * 根据类型查询项目
     *
     * @param type
     * @return
     */
    List<Project> queryProjectByType(Integer type);

    /**
     * 我发布的项目
     * @param user
     * @return
     */
    List<Project> queryProjectByUserId(User user);
}
