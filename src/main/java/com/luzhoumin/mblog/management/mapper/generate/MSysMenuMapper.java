package com.luzhoumin.mblog.management.mapper.generate;

import com.luzhoumin.mblog.management.config.DBWriteConnection;
import com.luzhoumin.mblog.management.pojo.MSysMenu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MSysMenuMapper {
    @DBWriteConnection
    int deleteByPrimaryKey(String uuid);

    @DBWriteConnection
    int insert(MSysMenu record);

    @DBWriteConnection
    int insertSelective(MSysMenu record);

    @DBWriteConnection
    MSysMenu selectByPrimaryKey(String uuid);

    @DBWriteConnection
    int updateByPrimaryKeySelective(MSysMenu record);

    @DBWriteConnection
    int updateByPrimaryKey(MSysMenu record);
}