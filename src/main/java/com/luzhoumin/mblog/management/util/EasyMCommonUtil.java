package com.luzhoumin.mblog.management.util;

import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on September 23, 2019
 * Description:
 *
 * @author <a href="mailto:zmlu1996@gmail.com">Jacob Lu</a>
 * @since 1.8
 */
public class EasyMCommonUtil {
	/**
	 * 去除map中key的首部下划线。eg:
	 * _key     => key
	 * _order   => order
	 */
	public static <T> Map<String, T> transUnderLineKeyToNormal(Map<String, T> map) {
		Map<String, T> returnMap = new LinkedHashMap<>();
		if (map != null) {
			for (String s : map.keySet()) {
				if (StrUtil.isNotEmpty(s)) {
					if (s.startsWith("_")) {
						returnMap.put(s.substring(1), map.get(s));
					} else {
						returnMap.put(s, map.get(s));
					}
				}
			}
		} else return null;
		return returnMap;
	}

	public static <T> List<Map<String, T>> transUnderLineKeyToNormal(List<Map<String, T>> list) {
		List<Map<String, T>> returnList = new ArrayList<>();
		if (list != null) {
			for (Map<String, T> map : list) {
				returnList.add(transUnderLineKeyToNormal(map));
			}
		} else return null;
		return returnList;
	}
}
