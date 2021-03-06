package com.luzhoumin.mblog.management.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TMbUser implements Serializable {
	private Integer id;

	private String uid;

	private String name;

	private String pass;

	private String email;

	private String note;

	private Date createDate;

	private String createBy;

	private Date updateDate;

	private String updateBy;

	private Integer deleteFlag;

    private Date deleteDate;

    private static final long serialVersionUID = 1L;
}