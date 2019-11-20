package com.luzhoumin.mblog.management.util;

import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.pojo.AjaxJson;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 九月 19, 2019
 * Description:
 *
 * @author <a href="mailto:zmlu1996@gmail.com">Jacob Lu</a>
 * @since 1.8
 */
public class HttpServletUtil {
	/**
	 * Spring下获取request
	 */
	public static HttpServletRequest getRequest() {
		try {
			return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 获得请求路径
	 */
	public static String getRequestPath(HttpServletRequest request) {
		String requestPath = request.getRequestURI();
		if (requestPath.contains("?")) {// 去掉其他参数
			requestPath = requestPath.substring(0, requestPath.indexOf("?"));
		}
		requestPath = requestPath.substring(request.getContextPath().length() + 1);// 去掉项目路径
		requestPath = "/" + requestPath;
		return requestPath;
	}

	/**
	 * SpringMvc下获取cookie
	 */
	public static Cookie[] getCookie() {
		Cookie[] cookies = getRequest().getCookies();
		return cookies;
	}

	/**
	 * 获取当前域名的Schema(http，https)
	 */
	public static String getScheme() {
		//例：url为http://www.easym.com/weekly-price.html，scheme则为http

		HttpServletRequest request = getRequest();
		String scheme = request.getHeader("X-Forwarded-Scheme"); //此方式可以获取到https
		if (StrUtil.isEmpty(scheme)) {
			scheme = "http";
		}
		return scheme;
	}

	public static String getCurrentCompleteDomainName() {
		HttpServletRequest request = getRequest();
		String url;
		url = getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort()
				+ request.getContextPath();
		return url;
	}

	/**
	 * ajax请求返回
	 *
	 * @param response
	 * @param aj
	 */
	public static void ajaxResponse(HttpServletResponse response, AjaxJson aj) {
		try {
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(aj.getJsonObject().toString());
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			e.printStackTrace();
			aj.setSuccess(false);
			aj.setMsg("SYSTEM_ERROR");
			ajaxResponse(response, aj);
		}
	}
}
