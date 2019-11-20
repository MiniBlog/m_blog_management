package com.luzhoumin.mblog.management.service;

import java.util.List;
import java.util.Map;

/**
 * TypeDefineService
 */
public interface TypeDefineService {

	/**
	 * 获取类型定义列表
	 * @param mapParams
	 * @return
	 */
	public List<Map<String, Object>> getTypeDefineList(Map<String, String> mapParams);

	/**
	 * 获取type的描述
	 * <p>
	 * ！不建议用在循环中！
	 *
	 * @param typeId   type_id
	 * @param type_key type_key
	 * @param lang     多语言
	 * @return
	 */
	String getTypeDesc(String typeId, String type_key, String lang);

	/**
	 * 获取type Map
	 *
	 * @param typeId type_id
	 * @param lang   多语言
	 * @return
	 */
	Map<String, String> getTypeDescMap(String typeId, String lang);

	/**
	 * 获取类型 其他描述
	 * type value other
	 * @param typeId type_id
	 * @param lang   多语言
	 * @return
	 */
	Map<String, String> getTypeOtherDescMap(String typeId, String lang);
}
