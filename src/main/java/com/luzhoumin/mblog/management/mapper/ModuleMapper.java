package com.luzhoumin.mblog.management.mapper;

import java.util.List;
import java.util.Map;

public interface ModuleMapper {
	List<Map<String, Object>> getModuleList(Map<String, String> paramMap);

	int getModuleListCount(Map<String, String> paramMap);
}
