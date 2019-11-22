package com.luzhoumin.mblog.management.mapper;

import java.util.List;
import java.util.Map;

public interface ModelMapper {
	List<Map<String, Object>> getModelList(Map<String, String> paramMap);

	int getModelListCount(Map<String, String> paramMap);
}
