package com.luzhoumin.mblog.management.mapper.generate;

import com.luzhoumin.mblog.management.config.DBWriteConnection;
import com.luzhoumin.mblog.management.pojo.MSysMenu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MSysMenuMapper {
    @DBWriteConnection
    int deleteByPrimaryKey(Integer id);
    @DBWriteConnection
    int insert(MSysMenu record);
    @DBWriteConnection
    int insertSelective(MSysMenu record);
    @DBWriteConnection
    MSysMenu selectByPrimaryKey(Integer id);
    @DBWriteConnection
    int updateByPrimaryKeySelective(MSysMenu record);
    @DBWriteConnection
    int updateByPrimaryKey(MSysMenu record);
}