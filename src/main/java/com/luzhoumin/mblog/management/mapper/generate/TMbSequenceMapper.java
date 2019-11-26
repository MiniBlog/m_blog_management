package com.luzhoumin.mblog.management.mapper.generate;

import com.luzhoumin.mblog.management.config.DBWriteConnection;
import com.luzhoumin.mblog.management.pojo.TMbSequence;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TMbSequenceMapper {
	@DBWriteConnection
	int deleteByPrimaryKey(Integer id);

	@DBWriteConnection
    int insert(TMbSequence record);

	@DBWriteConnection
    int insertSelective(TMbSequence record);

	@DBWriteConnection
    TMbSequence selectByPrimaryKey(Integer id);

	@DBWriteConnection
    int updateByPrimaryKeySelective(TMbSequence record);

	@DBWriteConnection
    int updateByPrimaryKey(TMbSequence record);
}