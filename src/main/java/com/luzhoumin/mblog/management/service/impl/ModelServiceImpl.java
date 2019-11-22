package com.luzhoumin.mblog.management.service.impl;

import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.mapper.ModelMapper;
import com.luzhoumin.mblog.management.mapper.generate.MSysModelMapper;
import com.luzhoumin.mblog.management.pojo.MSysModel;
import com.luzhoumin.mblog.management.service.ModelService;
import com.luzhoumin.mblog.management.util.PageHelperUtil;
import com.luzhoumin.mblog.management.util.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Service
public class ModelServiceImpl implements ModelService {

	@Resource
	ModelMapper modelMapper;
	@Resource
	MSysModelMapper mSysModelMapper;

	@Override
	public Map<String, Object> getModelList(Map<String, String> paramMap, int pageNum, int pageSize) {
		log.info("ModelServiceImpl,getModelList:start");
		Map<String, Object> data = new HashMap<>();
		int modelListCount = modelMapper.getModelListCount(paramMap);
		List<Map<String, Object>> modelList = new ArrayList<>();
		if (modelListCount > 0) {
			PageHelperUtil.addPaging(pageNum, pageSize);
			modelList = modelMapper.getModelList(paramMap);
		}
		data.put("list", modelList);
		data.put("count", modelListCount);
		log.info("ModelServiceImpl,getModelList:end");
		return data;
	}


	@Override
	public MSysModel getModelInfoById(int id) {
		log.info("ModelServiceImpl,getModelInfoById:start");
		MSysModel mSysModel = mSysModelMapper.selectByPrimaryKey(id);
		log.info("ModelServiceImpl,getModelInfoById:end");
		return mSysModel;
	}

	@Override
	public boolean deleteModel(MSysModel model) {
		log.info("ModelServiceImpl,deleteModel:start");
		try {
			String loginUser = StrUtil.toString(SessionUtil.getSessionLoginUserName());
			Date now = new Date();
			model.setUpdateBy(loginUser);
			model.setUpdateDate(now);
			model.setDeleteFlag(1);
			model.setDeleteDate(now);
			mSysModelMapper.updateByPrimaryKeySelective(model);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ModelServiceImpl,deleteModel", e);
			return false;
		}
		log.info("ModelServiceImpl,deleteModel:end");
		return true;
	}
}
