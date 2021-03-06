package com.luzhoumin.mblog.management.service.impl;

import com.luzhoumin.mblog.management.mapper.LogRequestMapper;
import com.luzhoumin.mblog.management.service.LogRequestService;
import com.luzhoumin.mblog.management.util.PageHelperUtil;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Service
public class LogRequestServiceImpl implements LogRequestService {

	@Resource
	LogRequestMapper logRequestMapper;

	@Override
	public Map<String, Object> getRequestLogList(Map<String, String> paramMap, int pageNum, int pageSize) {
		log.info("LogServiceImpl,getRequestLogList:start");
		Map<String, Object> data = new HashMap<>();
		int userListCount = logRequestMapper.getLogRequestListCount(paramMap);
		List<Map<String, Object>> userList = new ArrayList<>();
		if (userListCount > 0) {
			PageHelperUtil.addPaging(pageNum, pageSize);
			userList = logRequestMapper.getLogRequestList(paramMap);
		}
		data.put("list", userList);
		data.put("count", userListCount);
		log.info("LogServiceImpl,getRequestLogList:end");
		return data;
	}
}
