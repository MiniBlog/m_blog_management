package com.luzhoumin.mblog.management.mapper.generate;

import com.luzhoumin.mblog.management.config.DBWriteConnection;
import com.luzhoumin.mblog.management.pojo.MSysModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MSysModelMapper {
	@DBWriteConnection
	int deleteByPrimaryKey(Integer id);

	@DBWriteConnection
	int insert(MSysModel record);

	@DBWriteConnection
	int insertSelective(MSysModel record);

	@DBWriteConnection
	MSysModel selectByPrimaryKey(Integer id);

	@DBWriteConnection
	int updateByPrimaryKeySelective(MSysModel record);

	@DBWriteConnection
	int updateByPrimaryKeyWithBLOBs(MSysModel record);

	@DBWriteConnection
	int updateByPrimaryKey(MSysModel record);
}