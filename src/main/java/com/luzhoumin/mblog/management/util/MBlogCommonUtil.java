package com.luzhoumin.mblog.management.util;

import cn.hutool.core.util.StrUtil;

import java.util.*;

/**
 * Created on September 23, 2019
 * Description:
 *
 * @author <a href="mailto:zmlu1996@gmail.com">Jacob Lu</a>
 * @since 1.8
 */
public class MBlogCommonUtil {
	/**
	 * 去除map中key的首部下划线。eg:
	 * _key     => key
	 * _order   => order
	 */
	public static <T> Map<String, T> transUnderLineKeyToNormal(Map<String, T> map) {
		Map<String, T> returnMap = null;
		if (map != null) {
			returnMap = new LinkedHashMap<>();
			for (String s : map.keySet()) {
				if (StrUtil.isNotEmpty(s)) {
					if (s.startsWith("_")) {
						returnMap.put(s.substring(1), map.get(s));
					} else {
						returnMap.put(s, map.get(s));
					}
				}
			}
		}
		return returnMap;
	}

	public static <T> List<Map<String, T>> transUnderLineKeyToNormal(List<Map<String, T>> list) {
		List<Map<String, T>> returnList = null;
		if (list != null) {
			returnList = new ArrayList<>();
			for (Map<String, T> map : list) {
				returnList.add(transUnderLineKeyToNormal(map));
			}
		}
		return returnList;
	}

	/**
	 * 移除map中value为null的值
	 */
	public static Map<String, Object> removeMapNullValue(Map<String, Object> oldMap) {
		if (oldMap == null) {
			return null;
		}
		Map<String, Object> newMap = new HashMap<>();
		Set<Map.Entry<String, Object>> entries = oldMap.entrySet();
		for (Map.Entry<String, Object> entry : entries) {
			String newKey = entry.getKey();
			Object newValue = entry.getValue();
			if (newValue != null) {
				newMap.put(newKey, newValue);
			}
		}
		return newMap;
	}
}
