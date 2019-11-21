package com.luzhoumin.mblog.management.mapper.generate;

import com.luzhoumin.mblog.management.config.DBWriteConnection;
import com.luzhoumin.mblog.management.pojo.MSysDemo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MSysDemoMapper {
    @DBWriteConnection
    int deleteByPrimaryKey(Integer id);
    @DBWriteConnection
    int insert(MSysDemo record);
    @DBWriteConnection
    int insertSelective(MSysDemo record);
    @DBWriteConnection
    MSysDemo selectByPrimaryKey(Integer id);
    @DBWriteConnection
    int updateByPrimaryKeySelective(MSysDemo record);
    @DBWriteConnection
    int updateByPrimaryKey(MSysDemo record);
}