package com.luzhoumin.mblog.management.service.impl;

import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.mapper.TypeDefineMapper;
import com.luzhoumin.mblog.management.service.TypeDefineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class TypeDefineServiceImpl implements TypeDefineService {
	@Resource
	private TypeDefineMapper typeDefineMapper;

	/**
	 * 获取类型定义列表
	 * @param mapParams
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getTypeDefineList(Map<String, String> mapParams) {
		log.info("TypeDefineServiceImpl,getTypeDefineList:start");
		List<Map<String, Object>> typeDefineList = new ArrayList<Map<String, Object>>();

		String typeId = mapParams.get("typeId");
		if (StrUtil.isEmpty(typeId)) {
			log.info("TypeDefineServiceImpl,getTypeDefineList:INCOMPLETE_PARAMETERS");
			log.info("TypeDefineServiceImpl,getTypeDefineList:end");
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

		typeDefineList = typeDefineMapper.getTypeDefineList(sqlParams);

		log.info("TypeDefineServiceImpl,getTypeDefineList:end");
		return typeDefineList;
	}

	@Override
	public String getTypeDesc(String typeId, String type_key, String lang) {
		return getTypeDescMap(typeId, lang).get(type_key);
	}

	@Override
	public Map<String, String> getTypeDescMap(String typeId, String lang) {
		log.info("TypeDefineServiceImpl,getTypeDescMap:start");
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("lang", lang);
		paramMap.put("typeId", typeId);
		List<Map<String, Object>> typeDefineList = getTypeDefineList(paramMap);
		Map<String, String> returnMap = new HashMap<>();
		for (Map<String, Object> row : typeDefineList) {
			returnMap.put(String.valueOf(row.get("type_value")), String.valueOf(row.get("type_desc_m")));
		}
		log.info("TypeDefineServiceImpl,getTypeDescMap:end");
		return returnMap;
	}

	@Override
	public Map<String, String> getTypeOtherDescMap(String typeId, String lang) {
		log.info("TypeDefineServiceImpl,getTypeOtherDescMap:start");
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("lang", lang);
		paramMap.put("typeId", typeId);
		List<Map<String, Object>> typeDefineList = getTypeDefineList(paramMap);
		Map<String, String> returnMap = new HashMap<>();
		for (Map<String, Object> row : typeDefineList) {
			returnMap.put(String.valueOf(row.get("type_value")), String.valueOf(row.get("type_value_other")));
		}
		log.info("TypeDefineServiceImpl,getTypeOtherDescMap:end");
		return returnMap;
	}
}
