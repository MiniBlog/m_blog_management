package com.luzhoumin.mblog.management.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MSysLogRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String userUuid;
	private String userName;
	private String source;
	private String path;
	private String query;
	private String params;
	private String ip;
	private Date createDate;
}