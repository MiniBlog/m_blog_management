package com.luzhoumin.mblog.management.mapper.generate;

import com.luzhoumin.mblog.management.pojo.MSysModule;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MSysModuleMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(MSysModule record);

	int insertSelective(MSysModule record);

	MSysModule selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(MSysModule record);

	int updateByPrimaryKeyWithBLOBs(MSysModule record);

	int updateByPrimaryKey(MSysModule record);
}