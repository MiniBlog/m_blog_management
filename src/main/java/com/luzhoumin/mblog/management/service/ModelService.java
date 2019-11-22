package com.luzhoumin.mblog.management.service;

import com.luzhoumin.mblog.management.pojo.MSysModel;

import java.util.Map;

public interface ModelService {
	MSysModel getModelInfoById(int id);
	Map<String, Object> getModelList(Map<String, String> paramMap, int pageNum, int pageSize);
	boolean deleteModel(MSysModel model);
}
