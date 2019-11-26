package com.luzhoumin.mblog.management.service;

import com.luzhoumin.mblog.management.pojo.TMbModuleWithBLOBs;

import java.util.Map;

public interface ModuleService {
	TMbModuleWithBLOBs getModuleInfoById(int id);

	Map<String, Object> getModuleList(Map<String, String> paramMap, int pageNum, int pageSize);

	TMbModuleWithBLOBs getModule(int moduleId);

	boolean deleteModule(TMbModuleWithBLOBs model);

	boolean addModule(TMbModuleWithBLOBs model);

	boolean modifyModule(TMbModuleWithBLOBs model);
}
