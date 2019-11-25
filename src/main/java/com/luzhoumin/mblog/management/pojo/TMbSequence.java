package com.luzhoumin.mblog.management.pojo;

import java.io.Serializable;
import lombok.Data;

@Data
public class TMbSequence implements Serializable {
    private Integer id;

    private String seqId;

    private String prefixValue;

    private String dateValue;

    private Integer currentValue;

    private Integer currentValueInit;

    private Integer currentValueLength;

    private Integer incrementValue;

    private static final long serialVersionUID = 1L;
}