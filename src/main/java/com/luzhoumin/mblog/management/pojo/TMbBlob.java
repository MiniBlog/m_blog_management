package com.luzhoumin.mblog.management.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class TMbBlob implements Serializable {
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

    private static final long serialVersionUID = 1L;
}