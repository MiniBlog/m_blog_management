package com.luzhoumin.mblog.management.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MSysBlob implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String blob;
	private String name;
	private String originalName;
	private String address;
	private String createBy;
	private Date createDate;
	private String updateBy;
	private Date updateDate;
	private Integer deleteFlag;
	private Date deleteDate;
}