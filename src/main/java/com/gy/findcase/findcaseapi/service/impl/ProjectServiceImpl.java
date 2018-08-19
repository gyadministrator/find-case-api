package com.gy.findcase.findcaseapi.service.impl;

import com.gy.findcase.findcaseapi.entity.Project;
import com.gy.findcase.findcaseapi.entity.User;
import com.gy.findcase.findcaseapi.repository.ProjectRepository;
import com.gy.findcase.findcaseapi.service.ProjectService;
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
 * @date 2018/8/12 12:53
 * @email 1984629668@qq.com
 * @description
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public String saveReturnId(Project project) {
        return this.projectRepository.save(project).getId();
    }

    @Override
    public void save(Project project) {
        this.projectRepository.save(project);
    }

    @Override
    public Project saveReturnEntity(Project project) {
        return this.projectRepository.save(project);
    }

    @Override
    public void deleteById(String s) {
        this.projectRepository.deleteById(s);
    }

    @Override
    public Project queryById(String s) throws Exception {
        return this.projectRepository.getOne(s);
    }

    @Override
    public Items<Project> query() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        List<Project> all = this.projectRepository.findAll(sort);
        long count = this.projectRepository.count();
        return new Items<>(count, all);
    }

    @Override
    public PageQuery<Project> query(Integer currentPage, Integer pageSize, OrderType orderType, String... sortField) {
        return new QueryUtils<Project>().query(projectRepository, currentPage, pageSize, orderType, sortField);
    }

    @Override
    public List<Project> queryProjectByType(Integer type) {
        return this.projectRepository.findByType(type);
    }

    @Override
    public List<Project> queryProjectByUserId(User user) {
        return this.projectRepository.findByUser(user);
    }
}
