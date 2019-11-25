package com.luzhoumin.mblog.management.mapper.generate;

import com.luzhoumin.mblog.management.pojo.TMbModule;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TMbModuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TMbModule record);

    int insertSelective(TMbModule record);

    TMbModule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TMbModule record);

    int updateByPrimaryKeyWithBLOBs(TMbModule record);

    int updateByPrimaryKey(TMbModule record);
}