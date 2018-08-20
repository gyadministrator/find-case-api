package com.gy.findcase.findcaseapi.repository;

import com.gy.findcase.findcaseapi.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/8/20 11:28
 * @email 1984629668@qq.com
 * @description
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, String> {
    /**
     * 通过类型查询消息
     */
    List<Message> findByType(Integer type);
}
