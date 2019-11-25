package com.luzhoumin.mblog.management.mapper.generate;

import com.luzhoumin.mblog.management.pojo.TMbSequence;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TMbSequenceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TMbSequence record);

    int insertSelective(TMbSequence record);

    TMbSequence selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TMbSequence record);

    int updateByPrimaryKey(TMbSequence record);
}