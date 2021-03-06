package com.luzhoumin.mblog.management.mapper;

import com.luzhoumin.mblog.management.config.DBWriteConnection;

public interface SequenceMapper {

	/**
	 * 获取Sequence
	 *
	 * @param seqId
	 * @return
	 */
	@DBWriteConnection
	String getSequence(String seqId);
}