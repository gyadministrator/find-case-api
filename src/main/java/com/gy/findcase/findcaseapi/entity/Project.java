package com.gy.findcase.findcaseapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/8/12 12:39
 * @email 1984629668@qq.com
 * @description
 */
@EqualsAndHashCode()
@Data
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GenericGenerator(name = "generateUUID", strategy = "uuid")
    @GeneratedValue(generator = "generateUUID")
    private String id;

    /**
     * 项目截图
     */
    private String image;

    /**
     * 项目所属类型
     */
    private Integer type;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目链接
     */
    private String url;

    /**
     * 担任角色
     */
    private String role;

    /**
     * 项目描述
     */
    private String description;

    /**
     * 项目成果
     */
    private String score;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date start;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date end;

    @ManyToOne
    private User user;

    /**
     * 轮播图
     */
    private String one;

    private String two;

    private String three;

    private String four;
}
