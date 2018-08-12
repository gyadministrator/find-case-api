package com.gy.findcase.findcaseapi.repository;

import com.gy.findcase.findcaseapi.entity.Collection;
import com.gy.findcase.findcaseapi.entity.Project;
import com.gy.findcase.findcaseapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/8/12 19:26
 * @email 1984629668@qq.com
 * @description
 */
@Repository
public interface CollectRepository extends JpaRepository<Collection, String> {
    List<Collection> findByUser(User user);

    List<Collection> findByUserAndProject(User user, Project project);
}
