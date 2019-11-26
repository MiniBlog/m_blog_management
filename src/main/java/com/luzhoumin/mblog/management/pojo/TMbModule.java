package com.luzhoumin.mblog.management.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TMbModule implements Serializable {
	private Integer id;

	private String uid;

	private String name;

	private String type;

	private String note;

	private String createBy;

	private Date createDate;

	private String updateBy;

	private Date updateDate;

    private Date deleteDate;

	private Integer deleteFlag;

    private static final long serialVersionUID = 1L;
}