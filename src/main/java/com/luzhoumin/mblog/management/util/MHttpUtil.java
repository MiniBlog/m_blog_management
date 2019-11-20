package com.luzhoumin.mblog.management.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;

import java.util.Map;

public class MHttpUtil {

	public static JSONObject get(String requestKey, Map<String, Object> mapParams) {
		//移除值为null的参数
		Map<String, Object> newMap = MBlogCommonUtil.removeMapNullValue(mapParams);

		//获取请求地址
		String uri = PropertiesUtil.getHttpRequestPath(requestKey);

		//http请求
		String post = HttpUtil.get(uri, newMap);

		//返回结果
		return new JSONObject(post);
	}

	public static JSONObject post(String requestKey, Map<String, Object> mapParams) {
		//移除值为null的参数
		Map<String, Object> newMap = MBlogCommonUtil.removeMapNullValue(mapParams);

		//获取请求地址
		String uri = PropertiesUtil.getHttpRequestPath(requestKey);

		//http请求
		String post = HttpUtil.post(uri, newMap);

		//返回结果
		return new JSONObject(post);
	}

	/**
	 * Http请求成功判断
	 */
	public static boolean httpRequestSuccess(JSONObject obj) {
		try {
			if (obj != null) {
				String code = StrUtil.toString(obj.get("code"));
				return "0".equals(code);
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

}
