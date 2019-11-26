package com.luzhoumin.mblog.management.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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

	private String note;

	private String createBy;

	private Date createDate;

	private String updateBy;

	private Date updateDate;

	private Integer deleteFlag;

    private Date deleteDate;

    private static final long serialVersionUID = 1L;
}