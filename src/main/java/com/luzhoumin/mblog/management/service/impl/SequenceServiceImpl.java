package com.luzhoumin.mblog.management.service.impl;


import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.mapper.SequenceMapper;
import com.luzhoumin.mblog.management.service.SequenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * SequenceServiceImpl
 */
@Slf4j
@Service
public class SequenceServiceImpl implements SequenceService {

	@Resource
	private SequenceMapper sequenceMapper;

	/**
	 * 获取Sequence
	 */
	@Override
	public String getSequence(String seqId) {
		log.info("********** SequenceServiceImpl:start **********");
		String sequence = "";
		if (StrUtil.isNotEmpty(seqId)) {
			sequence = sequenceMapper.getSequence(seqId);
		}

		log.info("********** SequenceServiceImpl:end **********");
		return sequence;
	}
}
