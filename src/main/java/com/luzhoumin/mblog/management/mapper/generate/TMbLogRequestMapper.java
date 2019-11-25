package com.luzhoumin.mblog.management.mapper.generate;

import com.luzhoumin.mblog.management.pojo.TMbLogRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TMbLogRequestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TMbLogRequest record);

    int insertSelective(TMbLogRequest record);

    TMbLogRequest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TMbLogRequest record);

    int updateByPrimaryKey(TMbLogRequest record);
}