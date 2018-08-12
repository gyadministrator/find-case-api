package com.gy.findcase.findcaseapi.service;

import com.gy.findcase.findcaseapi.entity.Collection;
import com.gy.findcase.findcaseapi.entity.User;

import java.util.List;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/8/12 19:27
 * @email 1984629668@qq.com
 * @description
 */
public interface CollectService extends BaseService<Collection, String> {
    List<Collection> queryByUserId(User user);
}
