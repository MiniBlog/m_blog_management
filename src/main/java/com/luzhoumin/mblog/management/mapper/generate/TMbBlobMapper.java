package com.luzhoumin.mblog.management.mapper.generate;

import com.luzhoumin.mblog.management.config.DBWriteConnection;
import com.luzhoumin.mblog.management.pojo.TMbBlob;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TMbBlobMapper {
    @DBWriteConnection
    int deleteByPrimaryKey(Integer id);
    @DBWriteConnection
    int insert(TMbBlob record);
    @DBWriteConnection
    int insertSelective(TMbBlob record);
    @DBWriteConnection
    TMbBlob selectByPrimaryKey(Integer id);
    @DBWriteConnection
    int updateByPrimaryKeySelective(TMbBlob record);
    @DBWriteConnection
    int updateByPrimaryKey(TMbBlob record);
}