package com.luzhoumin.mblog.management.mapper.generate;

import com.luzhoumin.mblog.management.config.DBWriteConnection;
import com.luzhoumin.mblog.management.pojo.MSysBlob;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MSysBlobMapper {
    @DBWriteConnection
    int deleteByPrimaryKey(Integer id);
    @DBWriteConnection
    int insert(MSysBlob record);
    @DBWriteConnection
    int insertSelective(MSysBlob record);
    @DBWriteConnection
    MSysBlob selectByPrimaryKey(Integer id);
    @DBWriteConnection
    int updateByPrimaryKeySelective(MSysBlob record);
    @DBWriteConnection
    int updateByPrimaryKey(MSysBlob record);
}