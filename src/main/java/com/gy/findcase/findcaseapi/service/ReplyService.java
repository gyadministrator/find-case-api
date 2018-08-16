package com.gy.findcase.findcaseapi.service;

import com.gy.findcase.findcaseapi.entity.Problem;
import com.gy.findcase.findcaseapi.entity.Reply;

import java.util.List;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/8/16 11:36
 * @email 1984629668@qq.com
 * @description
 */
public interface ReplyService extends BaseService<Reply, String> {
    /**
     * 通过问题查询评论数
     *
     * @param problem
     * @return
     */
    List<Reply> queryByProblem(Problem problem);
}
