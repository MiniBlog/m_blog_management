package com.luzhoumin.mblog.management.util;

import com.luzhoumin.mblog.management.mapper.generate.MSysLogRequestMapper;
import com.luzhoumin.mblog.management.pojo.MSysLogRequest;
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
	MSysLogRequestMapper mSysLogRequestMapper;

	/**
	 * 记录请求日志
	 */
	public static void logRequest(MSysLogRequest mSysLogRequest) {
		logUtil.mSysLogRequestMapper.insertSelective(mSysLogRequest);
	}

	@PostConstruct
	public void init() {
		logUtil = this;
	}
}
