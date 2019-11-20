package com.luzhoumin.mblog.management.service.impl;


import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.mapper.SysSequenceMapper;
import com.luzhoumin.mblog.management.service.SysSequenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * SequenceServiceImpl
 */
@Service
public class SysSequenceServiceImpl implements SysSequenceService {

	private static Logger logger = LoggerFactory.getLogger(SysSequenceServiceImpl.class);

	@Resource
	private SysSequenceMapper sysSequenceMapper;

	/**
	 * 获取Sequence
	 */
	@Override
	public String getSequence(String seqId) {
		logger.info("********** SequenceServiceImpl:start **********");
		String sequence = "";
		if (StrUtil.isNotEmpty(seqId)) {
			sequence = sysSequenceMapper.getSequence(seqId);
		}

		logger.info("********** SequenceServiceImpl:end **********");
		return sequence;
	}
}
