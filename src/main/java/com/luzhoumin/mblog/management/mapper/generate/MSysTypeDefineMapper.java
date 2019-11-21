package com.luzhoumin.mblog.management.mapper.generate;

import com.luzhoumin.mblog.management.config.DBWriteConnection;
import com.luzhoumin.mblog.management.pojo.MSysTypeDefine;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MSysTypeDefineMapper {
    @DBWriteConnection
    int deleteByPrimaryKey(Integer id);
    @DBWriteConnection
    int insert(MSysTypeDefine record);
    @DBWriteConnection
    int insertSelective(MSysTypeDefine record);
    @DBWriteConnection
    MSysTypeDefine selectByPrimaryKey(Integer id);
    @DBWriteConnection
    int updateByPrimaryKeySelective(MSysTypeDefine record);
    @DBWriteConnection
    int updateByPrimaryKey(MSysTypeDefine record);
}