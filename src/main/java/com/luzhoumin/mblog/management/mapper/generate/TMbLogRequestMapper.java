package com.luzhoumin.mblog.management.mapper.generate;

import com.luzhoumin.mblog.management.config.DBWriteConnection;
import com.luzhoumin.mblog.management.pojo.TMbLogRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TMbLogRequestMapper {
	@DBWriteConnection
	int deleteByPrimaryKey(Integer id);

	@DBWriteConnection
    int insert(TMbLogRequest record);

	@DBWriteConnection
    int insertSelective(TMbLogRequest record);

	@DBWriteConnection
    TMbLogRequest selectByPrimaryKey(Integer id);

	@DBWriteConnection
    int updateByPrimaryKeySelective(TMbLogRequest record);

	@DBWriteConnection
    int updateByPrimaryKey(TMbLogRequest record);
}