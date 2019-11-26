package com.luzhoumin.mblog.management.mapper.generate;

import com.luzhoumin.mblog.management.config.DBWriteConnection;
import com.luzhoumin.mblog.management.pojo.TMbMenu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TMbMenuMapper {
	@DBWriteConnection
	int deleteByPrimaryKey(Integer id);

	@DBWriteConnection
    int insert(TMbMenu record);

	@DBWriteConnection
    int insertSelective(TMbMenu record);

	@DBWriteConnection
    TMbMenu selectByPrimaryKey(Integer id);

	@DBWriteConnection
    int updateByPrimaryKeySelective(TMbMenu record);

	@DBWriteConnection
    int updateByPrimaryKey(TMbMenu record);
}