package com.luzhoumin.mblog.management.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MSysModule implements Serializable {
	private Integer id;

	private String uid;

	private String name;

	private String note;

	private String createBy;

	private Date createDate;

	private String updateBy;

	private Date updateDate;

	private Integer deleteFlag;

    private Date deleteDate;

    private byte[] template;

    private static final long serialVersionUID = 1L;
}