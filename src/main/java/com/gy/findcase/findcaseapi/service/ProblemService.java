package com.gy.findcase.findcaseapi.service;

import com.gy.findcase.findcaseapi.entity.Problem;
import com.gy.findcase.findcaseapi.entity.User;

import java.util.List;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/8/16 11:35
 * @email 1984629668@qq.com
 * @description
 */
public interface ProblemService extends BaseService<Problem, String> {
    /**
     * 我发布的问题
     *
     * @param user
     * @return
     */
    List<Problem> queryByUser(User user);
}
