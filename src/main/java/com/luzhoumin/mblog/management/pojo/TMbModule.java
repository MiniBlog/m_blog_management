package com.luzhoumin.mblog.management.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class TMbModule implements Serializable {
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