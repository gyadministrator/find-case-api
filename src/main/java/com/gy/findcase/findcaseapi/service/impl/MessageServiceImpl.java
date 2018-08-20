package com.gy.findcase.findcaseapi.service.impl;

import com.gy.findcase.findcaseapi.entity.Message;
import com.gy.findcase.findcaseapi.repository.MessageRepository;
import com.gy.findcase.findcaseapi.service.MessageService;
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
 * @date 2018/8/20 11:31
 * @email 1984629668@qq.com
 * @description
 */
@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public String saveReturnId(Message message) {
        return this.messageRepository.save(message).getId();
    }

    @Override
    public void save(Message message) {
        this.messageRepository.save(message);
    }

    @Override
    public Message saveReturnEntity(Message message) {
        return this.messageRepository.save(message);
    }

    @Override
    public void deleteById(String s) {
        this.messageRepository.deleteById(s);
    }

    @Override
    public Message queryById(String s) throws Exception {
        return this.messageRepository.getOne(s);
    }

    @Override
    public Items<Message> query() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        List<Message> all = this.messageRepository.findAll(sort);
        long count = this.messageRepository.count();
        return new Items<>(count, all);
    }

    @Override
    public PageQuery<Message> query(Integer currentPage, Integer pageSize, OrderType orderType, String... sortField) {
        return new QueryUtils<Message>().query(messageRepository, currentPage, pageSize, orderType, sortField);
    }

    @Override
    public List<Message> queryByType(Integer type) {
        return this.messageRepository.findByType(type);
    }
}
