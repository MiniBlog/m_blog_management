package com.luzhoumin.mblog.management.util;

import cn.hutool.core.util.StrUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on September 26, 2019
 * Description:
 *
 * @author <a href="mailto:zmlu1996@gmail.com">Jacob Lu</a>
 * @since 1.8
 */
public class ConvertUtil {
	/**
	 * Request中的参数转为map
	 *
	 * @param request
	 * @return
	 */
	public static Map<String, String> requestToMap(HttpServletRequest request) {
		Map<String, String> returnMap = new HashMap<>();
		Map<String, String[]> paraMap = request.getParameterMap();
		for (String key : paraMap.keySet()) {
			String[] value = paraMap.get(key);
			if (value != null && value.length > 0) {
				if (value.length == 1) {
					returnMap.put(key, value[0]);
				} else {
					returnMap.put(key, Arrays.toString(value));
				}
			}
		}
		return returnMap;
	}

	/**
	 * Request中的参数转为map
	 *
	 * @param request
	 * @return
	 */
	public static String requestToString(HttpServletRequest request) {
		StringBuilder s = new StringBuilder();
		Map<String, String[]> paraMap = request.getParameterMap();
		for (String key : paraMap.keySet()) {
			if ("page".equals(key)) {
				continue;
			}
			String[] value = paraMap.get(key);
			if (value != null && value.length > 0) {
				if (value.length == 1) {
					s.append(key).append("=").append(value[0]).append("&");
				} else {
					s.append(key).append("=").append(Arrays.toString(value)).append("&");
				}
			}
		}
		if (StrUtil.isNotEmpty(s.toString()) && s.length() > 1) {
			s = new StringBuilder(s.substring(0, s.length() - 1));
		}
		return "".equals(s.toString()) ? null : s.toString();
	}
}
