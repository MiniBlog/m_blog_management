package com.luzhoumin.mblog.management.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class TMbMenu implements Serializable {
    private Integer id;

    private String title;

    private String key;

    private String icon;

    private String href;

    private Integer order;

    private Boolean group;

    private String parent;

    private Boolean edFlag;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private Integer deleteFlag;

    private Date deleteDate;

    private static final long serialVersionUID = 1L;
}