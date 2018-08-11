package com.gy.findcase.findcaseapi.service;

import com.gy.findcase.findcaseapi.service.support.Items;
import com.gy.findcase.findcaseapi.service.support.OrderType;
import com.gy.findcase.findcaseapi.service.support.PageQuery;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author gy
 * @Date: Create in 2018/3/31 16:00
 * @Description
 * @Modified By:
 */
public interface BaseService<T, ID> {


    @Transactional
    ID saveReturnId(T t);

    /**
     * 保存对象没有返回值
     */
    @Transactional
    void save(T t);

    /**
     * 保存对象返回该实体
     *
     * @return
     */
    @Transactional
    T saveReturnEntity(T t);

    /**
     * 更具ID删除数据
     *
     * @param id
     */
    @Transactional
    void deleteById(ID id);


    T queryById(ID id) throws Exception;

    /**
     * 查询所有
     *
     * @return
     */
    Items<T> query();

    /**
     * 分页查询
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageQuery<T> query(Integer currentPage, Integer pageSize, OrderType orderType, String... sortField);
}
