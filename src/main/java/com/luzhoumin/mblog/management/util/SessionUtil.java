package com.luzhoumin.mblog.management.util;

import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.constant.EasyMConstant;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Session工具类
 */
public class SessionUtil {

	/**
	 * 获取session
	 */
	public static HttpSession getSession() {
		try {
			return Objects.requireNonNull(HttpServletUtil.getRequest()).getSession();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 从session中获取登录用户uuid
	 *
	 * @return 登录用户uuid
	 */
	public static Object getSessionLoginUserUuid() {
		HttpSession session = getSession();
		if (session == null) {
			return null;
		}
		return session.getAttribute(EasyMConstant.SESSION_M_USER_UUID);
	}

	/**
	 * 往session中设定登录用户uuid
	 *
	 * @param uuid 登录用户uuid
	 */
	public static void setSessionLoginUserUuid(String uuid) {
		HttpSession session = getSession();
		if (session != null) {
			if (StrUtil.isNotEmpty(uuid)) {
				session.setAttribute(EasyMConstant.SESSION_M_USER_UUID, uuid);
			} else {
				session.removeAttribute(EasyMConstant.SESSION_M_USER_UUID);
			}
		}
	}

	/**
	 * 从session中获取登录用户name
	 *
	 * @return 登录用户name
	 */
	public static Object getSessionLoginUserName() {
		HttpSession session = getSession();
		if (session == null) {
			return null;
		}
		return session.getAttribute(EasyMConstant.SESSION_M_USER_NAME);
	}

	/**
	 * 往session中设定登录用户name
	 *
	 * @param name 登录用户name
	 */
	public static void setSessionLoginUserName(String name) {
		HttpSession session = getSession();
		if (session != null) {
			if (StrUtil.isNotEmpty(name)) {
				session.setAttribute(EasyMConstant.SESSION_M_USER_NAME, name);
			} else {
				session.removeAttribute(EasyMConstant.SESSION_M_USER_NAME);
			}
		}
	}

	/**
	 * 清空session中的参数
	 */
	public static void clearSessionAttrs(String... except) {
		HttpSession session = getSession();
		List<String> exceptList = Arrays.asList(except);
		if (session != null) {
			Enumeration<String> attributeNames = session.getAttributeNames();
			Iterator<String> attributeName = attributeNames.asIterator();
			while (attributeName.hasNext()) {
				String attrs = attributeName.next();
				if (!exceptList.contains(attrs)) {
					session.removeAttribute(attributeName.next());
				}
			}
		}
	}

}
