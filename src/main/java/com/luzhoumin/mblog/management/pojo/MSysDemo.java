package com.luzhoumin.mblog.management.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MSysDemo implements Serializable {
    private String uuid;

    private String name;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private Integer deleteFlag;

    private Date deleteDate;

    private static final long serialVersionUID = 1L;
}