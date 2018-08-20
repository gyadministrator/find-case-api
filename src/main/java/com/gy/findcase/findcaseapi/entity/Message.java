package com.gy.findcase.findcaseapi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/8/16 21:03
 * @email 1984629668@qq.com
 * @description
 */
@EqualsAndHashCode()
@Data
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GenericGenerator(name = "generateUUID", strategy = "uuid")
    @GeneratedValue(generator = "generateUUID")
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 消息类型 0 表示系统消息 1 表示其他消息
     */
    private Integer type;

    /**
     * 图片
     */
    private String image;
}
