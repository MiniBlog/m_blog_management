package com.luzhoumin.mblog.management.service.impl;


import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.mapper.SysSequenceMapper;
import com.luzhoumin.mblog.management.service.SysSequenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * SequenceServiceImpl
 */
@Slf4j
@Service
public class SysSequenceServiceImpl implements SysSequenceService {

	@Resource
	private SysSequenceMapper sysSequenceMapper;

	/**
	 * 获取Sequence
	 */
	@Override
	public String getSequence(String seqId) {
		log.info("********** SequenceServiceImpl:start **********");
		String sequence = "";
		if (StrUtil.isNotEmpty(seqId)) {
			sequence = sysSequenceMapper.getSequence(seqId);
		}

		log.info("********** SequenceServiceImpl:end **********");
		return sequence;
	}
}
