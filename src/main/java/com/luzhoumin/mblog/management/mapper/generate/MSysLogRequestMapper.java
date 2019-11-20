package com.luzhoumin.mblog.management.mapper.generate;

import com.luzhoumin.mblog.management.config.DBWriteConnection;
import com.luzhoumin.mblog.management.pojo.MSysLogRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MSysLogRequestMapper {
    @DBWriteConnection
    int deleteByPrimaryKey(Integer id);

    @DBWriteConnection
    int insert(MSysLogRequest record);

    @DBWriteConnection
    int insertSelective(MSysLogRequest record);

    @DBWriteConnection
    MSysLogRequest selectByPrimaryKey(Integer id);

    @DBWriteConnection
    int updateByPrimaryKeySelective(MSysLogRequest record);

    @DBWriteConnection
    int updateByPrimaryKey(MSysLogRequest record);
}