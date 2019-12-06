package com.luzhoumin.mblog.management.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Map;

@Slf4j
public class MHttpUtil {

	public static JSONObject get(String requestKey, Map<String, Object> mapParams) {
		Date startTime = new Date();
		log.info("HTTP_GET_START : [Time:" + DateUtil.formatDateTime(startTime) + "]");

		//获取请求地址
		String uri = PropertiesUtil.getHttpRequestPath(requestKey);
		log.info("HTTP_GET_URL : [" + uri + "]");

		//参数设定
		if (mapParams != null && mapParams.size() > 0) {
			//移除值为null的参数
			mapParams = MBlogCommonUtil.removeMapNullValue(mapParams);
			log.info("HTTP_GET_PARAMS : [" + mapParams.toString() + "]");
		} else {
			log.info("HTTP_GET_PARAMS : 无参数");
		}

		//http请求
		String post = HttpUtil.get(uri, mapParams);
		log.info("HTTP_GET_RESULT : [" + post + "]");

		Date endTime = new Date();
		long diff = endTime.getTime() - startTime.getTime();
		log.info("HTTP_GET_END : [Time:" + DateUtil.formatDateTime(endTime) + "][Total Time: " + diff + "ms]");
		//返回结果
		return new JSONObject(post);
	}

	public static JSONObject post(String requestKey, Map<String, Object> mapParams) {
		Date startTime = new Date();
		log.info("HTTP_POST_START : [Time:" + DateUtil.formatDateTime(startTime) + "]");

		//获取请求地址
		String uri = PropertiesUtil.getHttpRequestPath(requestKey);
		log.info("HTTP_POST_URL : [" + uri + "]");

		//参数设定
		if (mapParams != null && mapParams.size() > 0) {
			//移除值为null的参数
			mapParams = MBlogCommonUtil.removeMapNullValue(mapParams);
			log.info("HTTP_POST_PARAMS : [" + mapParams.toString() + "]");
		} else {
			log.info("HTTP_POST_PARAMS : 无参数");
		}

		//http请求
		String post = HttpUtil.get(uri, mapParams);
		log.info("HTTP_POST_RESULT : [" + post + "]");

		Date endTime = new Date();
		long diff = endTime.getTime() - startTime.getTime();
		log.info("HTTP_POST_END : [Time:" + DateUtil.formatDateTime(endTime) + "][Total Time: " + diff + "ms]");
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
