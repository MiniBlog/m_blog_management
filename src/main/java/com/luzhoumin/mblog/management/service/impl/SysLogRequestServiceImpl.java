package com.luzhoumin.mblog.management.service.impl;

import com.luzhoumin.mblog.management.mapper.SysLogRequestMapper;
import com.luzhoumin.mblog.management.service.SysLogRequestService;
import com.luzhoumin.mblog.management.util.PageHelperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on October 10, 2019
 * Description:
 *
 * @author <a href="mailto:zmlu1996@gmail.com">Jacob Lu</a>
 * @since 1.8
 */
@Service
public class SysLogRequestServiceImpl implements SysLogRequestService {

	private static Logger logger = LoggerFactory.getLogger(SysLogRequestServiceImpl.class);
	@Resource
	SysLogRequestMapper sysLogRequestMapper;

	@Override
	public Map<String, Object> getRequestLogList(Map<String, String> paramMap, int pageNum, int pageSize) {
		logger.info("**************** LogServiceImpl,getRequestLogList:start ****************");
		Map<String, Object> data = new HashMap<>();
		int userListCount = sysLogRequestMapper.getLogRequestListCount(paramMap);
		List<Map<String, Object>> userList = new ArrayList<>();
		if (userListCount > 0) {
			PageHelperUtil.addPaging(pageNum, pageSize);
			userList = sysLogRequestMapper.getLogRequestList(paramMap);
		}
		data.put("list", userList);
		data.put("count", userListCount);
		logger.info("**************** LogServiceImpl,getRequestLogList:end ****************");
		return data;
	}
}
