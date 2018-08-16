package com.gy.findcase.findcaseapi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/8/16 11:28
 * @email 1984629668@qq.com
 * @description
 */
@EqualsAndHashCode()
@Data
@Entity
@Table(name = "reply")
public class Reply {
    @Id
    @GenericGenerator(name = "generateUUID", strategy = "uuid")
    @GeneratedValue(generator = "generateUUID")
    private String id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Problem problem;

    /**
     * 回答的内容
     */
    private String content;
}
