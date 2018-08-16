package com.gy.findcase.findcaseapi.service.impl;

import com.gy.findcase.findcaseapi.entity.Problem;
import com.gy.findcase.findcaseapi.entity.Reply;
import com.gy.findcase.findcaseapi.repository.ReplyRepository;
import com.gy.findcase.findcaseapi.service.ReplyService;
import com.gy.findcase.findcaseapi.service.support.Items;
import com.gy.findcase.findcaseapi.service.support.OrderType;
import com.gy.findcase.findcaseapi.service.support.PageQuery;
import com.gy.findcase.findcaseapi.service.support.QueryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/8/16 11:40
 * @email 1984629668@qq.com
 * @description
 */
@Service
public class ReplyServiceImpl implements ReplyService {
    private final ReplyRepository replyRepository;

    @Autowired
    public ReplyServiceImpl(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    @Override
    public String saveReturnId(Reply reply) {
        return this.replyRepository.save(reply).getId();
    }

    @Override
    public void save(Reply reply) {
        this.replyRepository.save(reply);
    }

    @Override
    public Reply saveReturnEntity(Reply reply) {
        return this.replyRepository.save(reply);
    }

    @Override
    public void deleteById(String s) {
        this.replyRepository.deleteById(s);
    }

    @Override
    public Reply queryById(String s) throws Exception {
        return this.replyRepository.getOne(s);
    }

    @Override
    public Items<Reply> query() {
        List<Reply> all = this.replyRepository.findAll();
        long count = this.replyRepository.count();
        return new Items<>(count, all);
    }

    @Override
    public PageQuery<Reply> query(Integer currentPage, Integer pageSize, OrderType orderType, String... sortField) {
        return new QueryUtils<Reply>().query(replyRepository, currentPage, pageSize, orderType, sortField);
    }

    @Override
    public List<Reply> queryByProblem(Problem problem) {
        return this.replyRepository.findByProblem(problem);
    }
}
