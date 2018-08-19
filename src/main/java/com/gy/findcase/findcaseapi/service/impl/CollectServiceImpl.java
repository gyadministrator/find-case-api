package com.gy.findcase.findcaseapi.service.impl;

import com.gy.findcase.findcaseapi.entity.Collection;
import com.gy.findcase.findcaseapi.entity.User;
import com.gy.findcase.findcaseapi.repository.CollectRepository;
import com.gy.findcase.findcaseapi.service.CollectService;
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
 * @date 2018/8/12 19:27
 * @email 1984629668@qq.com
 * @description
 */
@Service
public class CollectServiceImpl implements CollectService {
    private final CollectRepository collectRepository;

    @Autowired
    public CollectServiceImpl(CollectRepository collectRepository) {
        this.collectRepository = collectRepository;
    }

    @Override
    public String saveReturnId(Collection collection) {
        return this.collectRepository.save(collection).getId();
    }

    @Override
    public void save(Collection collection) {
        List<Collection> userAndProject = this.collectRepository.findByUserAndProject(collection.getUser(), collection.getProject());
        if (userAndProject.size() == 0) {
            this.collectRepository.save(collection);
        }
    }

    @Override
    public Collection saveReturnEntity(Collection collection) {
        return this.collectRepository.save(collection);
    }

    @Override
    public void deleteById(String s) {
        this.collectRepository.deleteById(s);
    }

    @Override
    public Collection queryById(String s) throws Exception {
        return this.collectRepository.getOne(s);
    }

    @Override
    public Items<Collection> query() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        List<Collection> all = this.collectRepository.findAll(sort);
        long count = this.collectRepository.count();
        return new Items<>(count, all);
    }

    @Override
    public PageQuery<Collection> query(Integer currentPage, Integer pageSize, OrderType orderType, String... sortField) {
        return new QueryUtils<Collection>().query(collectRepository, currentPage, pageSize, orderType, sortField);
    }

    @Override
    public List<Collection> queryByUserId(User user) {
        return this.collectRepository.findByUser(user);
    }
}
