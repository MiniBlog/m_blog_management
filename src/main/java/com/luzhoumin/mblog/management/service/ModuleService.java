package com.luzhoumin.mblog.management.service;

import com.luzhoumin.mblog.management.pojo.TMbModule;

import java.util.Map;

public interface ModuleService {
	TMbModule getModuleInfoById(int id);

	Map<String, Object> getModuleList(Map<String, String> paramMap, int pageNum, int pageSize);

	boolean deleteModule(TMbModule model);

	boolean addModule(TMbModule model);

	boolean modifyModule(TMbModule model);
}
