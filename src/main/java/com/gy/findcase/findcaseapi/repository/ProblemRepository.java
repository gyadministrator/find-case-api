package com.gy.findcase.findcaseapi.repository;

import com.gy.findcase.findcaseapi.entity.Problem;
import com.gy.findcase.findcaseapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/8/16 11:34
 * @email 1984629668@qq.com
 * @description
 */
@Repository
public interface ProblemRepository extends JpaRepository<Problem, String> {
    List<Problem> findByUser(User user);
}
