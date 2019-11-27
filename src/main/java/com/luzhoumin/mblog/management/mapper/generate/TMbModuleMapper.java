package com.luzhoumin.mblog.management.mapper.generate;

import com.luzhoumin.mblog.management.config.DBWriteConnection;
import com.luzhoumin.mblog.management.pojo.TMbModule;
import com.luzhoumin.mblog.management.pojo.TMbModuleWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TMbModuleMapper {
    @DBWriteConnection
    int deleteByPrimaryKey(Integer id);

    @DBWriteConnection
    int insert(TMbModuleWithBLOBs record);

    @DBWriteConnection
    int insertSelective(TMbModuleWithBLOBs record);

    @DBWriteConnection
    TMbModuleWithBLOBs selectByPrimaryKey(Integer id);

    @DBWriteConnection
    int updateByPrimaryKeySelective(TMbModuleWithBLOBs record);

    @DBWriteConnection
    int updateByPrimaryKeyWithBLOBs(TMbModuleWithBLOBs record);

    @DBWriteConnection
    int updateByPrimaryKey(TMbModule record);
}