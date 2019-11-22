package com.luzhoumin.mblog.management.service.impl;

import com.luzhoumin.mblog.management.mapper.DemoMapper;
import com.luzhoumin.mblog.management.service.DemoService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Service
public class DemoServiceImpl implements DemoService {

	@Resource
	DemoMapper demoMapper;

	@Override
	public List<Map<String, Object>> getList() {
		log.info("logDemoServiceImpl,getList:start");
		List<Map<String, Object>> list = demoMapper.getList();
		log.info("logDemoServiceImpl,getList:end");
		return list;
	}
}
