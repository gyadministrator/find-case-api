package com.gy.findcase.findcaseapi.service;

import com.gy.findcase.findcaseapi.entity.Message;

import java.util.List;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/8/20 11:31
 * @email 1984629668@qq.com
 * @description
 */
public interface MessageService extends BaseService<Message, String> {
    List<Message> queryByType(Integer type);
}
