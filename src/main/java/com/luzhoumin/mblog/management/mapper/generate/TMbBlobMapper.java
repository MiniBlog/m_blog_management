package com.luzhoumin.mblog.management.mapper.generate;

import com.luzhoumin.mblog.management.pojo.TMbBlob;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TMbBlobMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TMbBlob record);

    int insertSelective(TMbBlob record);

    TMbBlob selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TMbBlob record);

    int updateByPrimaryKey(TMbBlob record);
}