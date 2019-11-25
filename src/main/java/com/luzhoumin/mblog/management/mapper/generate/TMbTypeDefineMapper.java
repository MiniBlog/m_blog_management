package com.luzhoumin.mblog.management.mapper.generate;

import com.luzhoumin.mblog.management.pojo.TMbTypeDefine;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TMbTypeDefineMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TMbTypeDefine record);

    int insertSelective(TMbTypeDefine record);

    TMbTypeDefine selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TMbTypeDefine record);

    int updateByPrimaryKey(TMbTypeDefine record);
}