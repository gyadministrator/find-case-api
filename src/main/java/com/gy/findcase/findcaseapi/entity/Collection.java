package com.gy.findcase.findcaseapi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/8/12 19:23
 * @email 1984629668@qq.com
 * @description
 */
@EqualsAndHashCode()
@Data
@Entity
@Table(name = "collect")
public class Collection {
    @Id
    @GenericGenerator(name = "generateUUID", strategy = "uuid")
    @GeneratedValue(generator = "generateUUID")
    private String id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Project project;
}
