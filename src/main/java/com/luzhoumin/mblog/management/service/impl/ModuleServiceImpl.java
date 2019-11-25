package com.luzhoumin.mblog.management.service.impl;

import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.mapper.ModuleMapper;
import com.luzhoumin.mblog.management.mapper.generate.TMbModuleMapper;
import com.luzhoumin.mblog.management.pojo.TMbModule;
import com.luzhoumin.mblog.management.service.ModuleService;
import com.luzhoumin.mblog.management.util.PageHelperUtil;
import com.luzhoumin.mblog.management.util.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@Service
public class ModuleServiceImpl implements ModuleService {

	@Resource
	ModuleMapper moduleMapper;
	@Resource
	TMbModuleMapper tMbModuleMapper;

	@Override
	public Map<String, Object> getModuleList(Map<String, String> paramMap, int pageNum, int pageSize) {
		log.info("ModelServiceImpl,getModelList:start");
		Map<String, Object> data = new HashMap<>();
		int modelListCount = moduleMapper.getModuleListCount(paramMap);
		List<Map<String, Object>> modelList = new ArrayList<>();
		if (modelListCount > 0) {
			PageHelperUtil.addPaging(pageNum, pageSize);
			modelList = moduleMapper.getModuleList(paramMap);
		}
		data.put("list", modelList);
		data.put("count", modelListCount);
		log.info("ModelServiceImpl,getModelList:end");
		return data;
	}


	@Override
	public TMbModule getModuleInfoById(int id) {
		log.info("ModelServiceImpl,getModelInfoById:start");
		TMbModule TMbModule = tMbModuleMapper.selectByPrimaryKey(id);
		log.info("ModelServiceImpl,getModelInfoById:end");
		return TMbModule;
	}

	@Override
	public boolean deleteModule(TMbModule model) {
		log.info("ModelServiceImpl,deleteModel:start");
		try {
			String loginUser = StrUtil.toString(SessionUtil.getSessionLoginUserName());
			Date now = new Date();
			model.setUpdateBy(loginUser);
			model.setUpdateDate(now);
			model.setDeleteFlag(1);
			model.setDeleteDate(now);
			tMbModuleMapper.updateByPrimaryKeySelective(model);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ModelServiceImpl,deleteModel", e);
			return false;
		}
		log.info("ModelServiceImpl,deleteModel:end");
		return true;
	}

	@Override
	public boolean addModule(TMbModule module) {
		log.info("ModelServiceImpl,addMenu:start");
		try {
			String loginUser = StrUtil.toString(SessionUtil.getSessionLoginUserName());
			Date now = new Date();

			module.setCreateBy(loginUser);
			module.setCreateDate(now);
			module.setUpdateBy(loginUser);
			module.setUpdateDate(now);

			tMbModuleMapper.insertSelective(module);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ModelServiceImpl,addModule", e);
			return false;
		}
		log.info("ModelServiceImpl,addModule:end");
		return true;
	}

	@Override
	public boolean modifyModule(TMbModule module) {
		log.info("ModelServiceImpl,modifyModule:start");
		try {
			String loginUser = StrUtil.toString(SessionUtil.getSessionLoginUserName());
			Date now = new Date();

			module.setUpdateBy(loginUser);
			module.setUpdateDate(now);

			tMbModuleMapper.updateByPrimaryKeySelective(module);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ModelServiceImpl,modifyModule", e);
			return false;
		}
		log.info("ModelServiceImpl,modifyModule:end");
		return true;
	}

}
