package com.luzhoumin.mblog.management.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TMbTypeDefine implements Serializable {
    private Integer id;

    private String type;

    private Integer order;

    private String value;

    private String valueOther;

    private String desc;

	private String note;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private Integer deleteFlag;

    private Date deleteDate;

    private static final long serialVersionUID = 1L;
}