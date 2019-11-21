package com.luzhoumin.mblog.management.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class MSysLogRequest implements Serializable {
    private Integer id;

    private String userUuid;

    private String userName;

    private String source;

    private String path;

    private String query;

    private String params;

    private String ip;

    private Date createDate;

    private static final long serialVersionUID = 1L;
}