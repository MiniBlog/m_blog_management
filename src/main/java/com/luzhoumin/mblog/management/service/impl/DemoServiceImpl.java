package com.luzhoumin.mblog.management.service.impl;

import com.luzhoumin.mblog.management.mapper.DemoMapper;
import com.luzhoumin.mblog.management.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created on 九月 19, 2019
 * Description:
 *
 * @author <a href="mailto:zmlu1996@gmail.com">Jacob Lu</a>
 * @since 1.8
 */
@Service
public class DemoServiceImpl implements DemoService {

	private static Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);
	@Resource
	DemoMapper demoMapper;

	@Override
	public List<Map<String, Object>> getList() {
		logger.info("**************** DemoServiceImpl,getList:start ****************");
		List<Map<String, Object>> list = demoMapper.getList();
		logger.info("**************** DemoServiceImpl,getList:end ****************");
		return list;
	}
}
