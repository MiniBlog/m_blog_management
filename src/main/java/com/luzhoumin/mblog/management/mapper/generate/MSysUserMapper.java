package com.luzhoumin.mblog.management.mapper.generate;

import com.luzhoumin.mblog.management.config.DBWriteConnection;
import com.luzhoumin.mblog.management.pojo.MSysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MSysUserMapper {
    @DBWriteConnection
    int deleteByPrimaryKey(String uuid);

    @DBWriteConnection
    int insert(MSysUser record);

    @DBWriteConnection
    int insertSelective(MSysUser record);

    @DBWriteConnection
    MSysUser selectByPrimaryKey(String uuid);

    @DBWriteConnection
    int updateByPrimaryKeySelective(MSysUser record);

    @DBWriteConnection
    int updateByPrimaryKey(MSysUser record);
}