package com.luzhoumin.mblog.management.mapper.generate;

import com.luzhoumin.mblog.management.pojo.TMbUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TMbUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TMbUser record);

    int insertSelective(TMbUser record);

    TMbUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TMbUser record);

    int updateByPrimaryKey(TMbUser record);
}