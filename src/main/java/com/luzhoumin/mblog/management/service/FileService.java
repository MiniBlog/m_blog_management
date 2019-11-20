package com.luzhoumin.mblog.management.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * FileService
 */
public interface FileService {

	/**
	 * 文件上传(对外统一接口)
	 * @param request
	 * @return
	 */
	public Map<String, Object> uploadFile(HttpServletRequest request);

	/**
	 * 文件下载(对外统一接口)
	 * @param request
	 * @param response
	 */
	public void downloadFile(HttpServletRequest request, HttpServletResponse response);

}
