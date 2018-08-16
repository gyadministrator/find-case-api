package com.gy.findcase.findcaseapi.repository;

import com.gy.findcase.findcaseapi.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/8/16 11:35
 * @email 1984629668@qq.com
 * @description
 */
@Repository
public interface ReplyRepository extends JpaRepository<Reply, String> {
}
