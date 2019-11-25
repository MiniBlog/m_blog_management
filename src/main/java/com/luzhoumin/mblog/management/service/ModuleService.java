package com.luzhoumin.mblog.management.service;

import com.luzhoumin.mblog.management.pojo.MSysModule;

import java.util.Map;

public interface ModuleService {
	MSysModule getModuleInfoById(int id);

	Map<String, Object> getModuleList(Map<String, String> paramMap, int pageNum, int pageSize);

	boolean deleteModule(MSysModule model);

	boolean addModule(MSysModule model);

	boolean modifyModule(MSysModule model);
}
