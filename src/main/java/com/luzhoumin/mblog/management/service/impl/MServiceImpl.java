package com.luzhoumin.mblog.management.service.impl;

import com.luzhoumin.mblog.management.mapper.MMapper;
import com.luzhoumin.mblog.management.service.MService;
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
 * Created on October 11, 2019
 * Description:
 *
 * @author <a href="mailto:zmlu1996@gmail.com">Jacob Lu</a>
 * @since 1.8
 */
@Service
public class MServiceImpl implements MService {

	private static Logger logger = LoggerFactory.getLogger(MServiceImpl.class);
	@Resource
	MMapper mMapper;

	@Override
	public List<Map<String, Object>> getTableColumns(Map<String, String> paramMap) {
		logger.info("**************** MServiceImpl,getTableColumns:start ****************");
		List<Map<String, Object>> tableColumns = mMapper.getTableColumns(paramMap);
		logger.info("**************** MServiceImpl,getTableColumns:end ****************");
		return tableColumns;
	}

	@Override
	public Map<String, Object> getList(Map<String, String> paramMap, int pageNum, int pageSize) {
		logger.info("**************** MServiceImpl,getList:start ****************");
		Map<String, Object> data = new HashMap<>();
		int listCount = mMapper.getListCount(paramMap);
		List<Map<String, Object>> list = new ArrayList<>();
		if (listCount > 0) {
			PageHelperUtil.addPaging(pageNum, pageSize);
			list = mMapper.getList(paramMap);
		}
		data.put("list", list);
		data.put("count", listCount);
		logger.info("**************** MServiceImpl,getList:end ****************");
		return data;
	}
}
