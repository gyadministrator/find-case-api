package com.gy.findcase.findcaseapi.service.impl;

import com.gy.findcase.findcaseapi.entity.Technology;
import com.gy.findcase.findcaseapi.repository.TechnologyRepository;
import com.gy.findcase.findcaseapi.service.TechnologyService;
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
 * @date 2018/8/20 20:20
 * @email 1984629668@qq.com
 * @description
 */
@Service
public class TechnologyServiceImpl implements TechnologyService {
    private final TechnologyRepository technologyRepository;

    @Autowired
    public TechnologyServiceImpl(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    @Override
    public String saveReturnId(Technology technology) {
        return this.technologyRepository.save(technology).getId();
    }

    @Override
    public void save(Technology technology) {
        this.technologyRepository.save(technology);
    }

    @Override
    public Technology saveReturnEntity(Technology technology) {
        return this.technologyRepository.save(technology);
    }

    @Override
    public void deleteById(String s) {
        this.technologyRepository.deleteById(s);
    }

    @Override
    public Technology queryById(String s) throws Exception {
        return this.technologyRepository.getOne(s);
    }

    @Override
    public Items<Technology> query() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        List<Technology> all = this.technologyRepository.findAll(sort);
        long count = this.technologyRepository.count();
        return new Items<>(count, all);
    }

    @Override
    public PageQuery<Technology> query(Integer currentPage, Integer pageSize, OrderType orderType, String... sortField) {
        return new QueryUtils<Technology>().query(technologyRepository, currentPage, pageSize, orderType, sortField);
    }
}
