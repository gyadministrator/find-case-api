package com.gy.findcase.findcaseapi.repository;

import com.gy.findcase.findcaseapi.entity.Project;
import com.gy.findcase.findcaseapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/8/12 12:51
 * @email 1984629668@qq.com
 * @description
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
    /**
     * 根据类型查询数据
     *
     * @param type
     * @return
     */
    List<Project> findByType(Integer type);

    /**
     * 我发布的项目
     *
     * @param user
     * @return
     */
    List<Project> findByUser(User user);
}
