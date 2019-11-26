package com.luzhoumin.mblog.management.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TMbModuleWithBLOBs extends TMbModule implements Serializable {
	private static final long serialVersionUID = 1L;
	private String template;
	private String css;
	private String js;
}