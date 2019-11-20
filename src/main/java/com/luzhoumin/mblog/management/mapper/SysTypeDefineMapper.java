package com.luzhoumin.mblog.management.mapper;

import java.util.List;
import java.util.Map;

public interface SysTypeDefineMapper {

	/**
	 * 获取区分定义列表
	 * @param sqlParams
	 * @return
	 */
	public List<Map<String, Object>> getTypeDefineList(Map<String, Object> sqlParams);
}