package com.gy.findcase.findcaseapi.service.impl;

import com.gy.findcase.findcaseapi.entity.Problem;
import com.gy.findcase.findcaseapi.entity.User;
import com.gy.findcase.findcaseapi.repository.ProblemRepository;
import com.gy.findcase.findcaseapi.service.ProblemService;
import com.gy.findcase.findcaseapi.service.support.Items;
import com.gy.findcase.findcaseapi.service.support.OrderType;
import com.gy.findcase.findcaseapi.service.support.PageQuery;
import com.gy.findcase.findcaseapi.service.support.QueryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/8/16 11:37
 * @email 1984629668@qq.com
 * @description
 */
@Service
public class ProblemServiceImpl implements ProblemService {
    private final ProblemRepository problemRepository;

    @Autowired
    public ProblemServiceImpl(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    @Override
    public String saveReturnId(Problem problem) {
        return this.problemRepository.save(problem).getId();
    }

    @Override
    public void save(Problem problem) {
        this.problemRepository.save(problem);
    }

    @Override
    public Problem saveReturnEntity(Problem problem) {
        return this.problemRepository.save(problem);
    }

    @Override
    public void deleteById(String s) {
        this.problemRepository.deleteById(s);
    }

    @Override
    public Problem queryById(String s) throws Exception {
        return this.problemRepository.getOne(s);
    }

    @Override
    public Items<Problem> query() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        List<Problem> all = this.problemRepository.findAll(sort);
        long count = this.problemRepository.count();
        return new Items<>(count, all);
    }

    @Override
    public PageQuery<Problem> query(Integer currentPage, Integer pageSize, OrderType orderType, String... sortField) {
        return new QueryUtils<Problem>().query(problemRepository, currentPage, pageSize, orderType, sortField);
    }

    @Override
    public List<Problem> queryByUser(User user) {
        return this.problemRepository.findByUser(user);
    }
}
