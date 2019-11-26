package com.luzhoumin.mblog.management.mapper.generate;

import com.luzhoumin.mblog.management.config.DBWriteConnection;
import com.luzhoumin.mblog.management.pojo.TMbUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TMbUserMapper {
	@DBWriteConnection
	int deleteByPrimaryKey(Integer id);

	@DBWriteConnection
    int insert(TMbUser record);

	@DBWriteConnection
    int insertSelective(TMbUser record);

	@DBWriteConnection
    TMbUser selectByPrimaryKey(Integer id);

	@DBWriteConnection
    int updateByPrimaryKeySelective(TMbUser record);

	@DBWriteConnection
    int updateByPrimaryKey(TMbUser record);
}