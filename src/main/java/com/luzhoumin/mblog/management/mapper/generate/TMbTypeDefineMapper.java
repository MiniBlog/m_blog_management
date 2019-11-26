package com.luzhoumin.mblog.management.mapper.generate;

import com.luzhoumin.mblog.management.config.DBWriteConnection;
import com.luzhoumin.mblog.management.pojo.TMbTypeDefine;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TMbTypeDefineMapper {
	@DBWriteConnection
	int deleteByPrimaryKey(Integer id);

	@DBWriteConnection
    int insert(TMbTypeDefine record);

	@DBWriteConnection
    int insertSelective(TMbTypeDefine record);

	@DBWriteConnection
    TMbTypeDefine selectByPrimaryKey(Integer id);

	@DBWriteConnection
    int updateByPrimaryKeySelective(TMbTypeDefine record);

	@DBWriteConnection
    int updateByPrimaryKey(TMbTypeDefine record);
}