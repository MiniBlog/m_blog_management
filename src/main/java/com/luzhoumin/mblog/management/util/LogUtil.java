package com.luzhoumin.mblog.management.util;

import com.luzhoumin.mblog.management.mapper.generate.TMbLogRequestMapper;
import com.luzhoumin.mblog.management.pojo.TMbLogRequest;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created on October 10, 2019
 * Description: 日志工具类
 *
 * @author <a href="mailto:zmlu1996@gmail.com">Jacob Lu</a>
 * @since 1.8
 */
@Service
public class LogUtil {

	private static LogUtil logUtil;
	@Resource
	TMbLogRequestMapper tMbLogRequestMapper;

	/**
	 * 记录请求日志
	 */
	public static void logRequest(TMbLogRequest tMbLogRequest) {
		logUtil.tMbLogRequestMapper.insertSelective(tMbLogRequest);
	}

	@PostConstruct
	public void init() {
		logUtil = this;
	}
}
