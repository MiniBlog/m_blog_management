package com.luzhoumin.mblog.management.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MSysUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private String uuid;
	private String name;
	private String pass;
	private String email;
	private Date createDate;
	private String createBy;
	private Date updateDate;
	private String updateBy;
	private Integer deleteFlag;
	private Date deleteDate;
}