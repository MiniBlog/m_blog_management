package com.luzhoumin.mblog.management.service.impl;

import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.mapper.SysTypeDefineMapper;
import com.luzhoumin.mblog.management.service.SysTypeDefineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysTypeDefineServiceImpl implements SysTypeDefineService {

	private static Logger logger = LoggerFactory.getLogger(SysTypeDefineServiceImpl.class);
	
	@Resource
	private SysTypeDefineMapper sysTypeDefineMapper;

	/**
	 * 获取类型定义列表
	 * @param mapParams
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getTypeDefineList(Map<String, String> mapParams){
		logger.info("********** TypeDefineServiceImpl,getTypeDefineList:start **********");
		List<Map<String, Object>> typeDefineList = new ArrayList<Map<String, Object>>();

		String typeId = mapParams.get("typeId");
		if (StrUtil.isEmpty(typeId)) {
			logger.info("********** TypeDefineServiceImpl,getTypeDefineList:INCOMPLETE_PARAMETERS **********");
			logger.info("********** TypeDefineServiceImpl,getTypeDefineList:end **********");
			return typeDefineList;
		}

		//语言默认为en
		String lang = mapParams.get("lang");
		if (StrUtil.isEmpty(lang)) {
			lang = "en";
		}

		//获取类型定义列表
		Map<String, Object> sqlParams = new HashMap<>();
		sqlParams.put("typeId", typeId);

		//指定typeValue，多个用逗号分割
		String typeValueInclude = mapParams.get("typeValueInclude");
		if (StrUtil.isNotEmpty(typeValueInclude)) {
			String[] typeValueIncludeArray = typeValueInclude.split(",");
			sqlParams.put("typeValueIncludeArray", typeValueIncludeArray);
		}

		//排除typeValue，多个用逗号分割
		String typeValueExclude = mapParams.get("typeValueExclude");
		if (StrUtil.isNotEmpty(typeValueExclude)) {
			String[] typeValueExcludeArray = typeValueExclude.split(",");
			sqlParams.put("typeValueExcludeArray", typeValueExcludeArray);
		}

		typeDefineList = sysTypeDefineMapper.getTypeDefineList(sqlParams);

		logger.info("********** TypeDefineServiceImpl,getTypeDefineList:end **********");
		return typeDefineList;
	}

	@Override
	public String getTypeDesc(String typeId, String type_key, String lang) {
		return getTypeDescMap(typeId, lang).get(type_key);
	}

	@Override
	public Map<String, String> getTypeDescMap(String typeId, String lang) {
		logger.info("********** TypeDefineServiceImpl,getTypeDescMap:start **********");
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("lang", lang);
		paramMap.put("typeId", typeId);
		List<Map<String, Object>> typeDefineList = getTypeDefineList(paramMap);
		Map<String, String> returnMap = new HashMap<>();
		for (Map<String, Object> row : typeDefineList) {
			returnMap.put(String.valueOf(row.get("type_value")), String.valueOf(row.get("type_desc_m")));
		}
		logger.info("********** TypeDefineServiceImpl,getTypeDescMap:end **********");
		return returnMap;
	}

	@Override
	public Map<String, String> getTypeOtherDescMap(String typeId, String lang) {
		logger.info("********** TypeDefineServiceImpl,getTypeOtherDescMap:start **********");
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("lang", lang);
		paramMap.put("typeId", typeId);
		List<Map<String, Object>> typeDefineList = getTypeDefineList(paramMap);
		Map<String, String> returnMap = new HashMap<>();
		for (Map<String, Object> row : typeDefineList) {
			returnMap.put(String.valueOf(row.get("type_value")), String.valueOf(row.get("type_value_other")));
		}
		logger.info("********** TypeDefineServiceImpl,getTypeOtherDescMap:end **********");
		return returnMap;
	}
}
