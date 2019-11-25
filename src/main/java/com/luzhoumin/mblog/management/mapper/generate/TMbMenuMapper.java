package com.luzhoumin.mblog.management.mapper.generate;

import com.luzhoumin.mblog.management.pojo.TMbMenu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TMbMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TMbMenu record);

    int insertSelective(TMbMenu record);

    TMbMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TMbMenu record);

    int updateByPrimaryKey(TMbMenu record);
}