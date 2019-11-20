package com.luzhoumin.mblog.management.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.github.pagehelper.util.StringUtil;
import com.luzhoumin.mblog.management.constant.EasyMConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件上传工具类
 * Created by Andy on 2018/1/3.
 */
public class UploadUtil {

	private static Logger logger = LoggerFactory.getLogger(UploadUtil.class);

	/**
	 * 文件上传
	 *
	 * @param bytes            文件字节流
	 * @param fileOriginalName 源文件名
	 * @return
	 */
	public static JSONObject uploadFile(byte[] bytes, String fileOriginalName) {
		return uploadFile(bytes, fileOriginalName, "mblog");
	}

	/**
	 * 文件上传
	 *
	 * @param bytes      文件字节流
	 * @param fileName   源文件名
	 * @param folderName 文件夹名(upload的下一层文件夹，可以为空)
	 * @return
	 */
	public static JSONObject uploadFile(byte[] bytes, String fileName, String folderName) {

		String filePath = "upload/";
		if (StringUtil.isNotEmpty(folderName)) {
			filePath = filePath + folderName + "/";
		}
		String nowDateStr = DateUtil.format(DateUtil.date(), "yyyyMMdd");
		filePath = filePath + nowDateStr + "/";

		Map<String, Object> mapParams = new HashMap<>();
		mapParams.put("fileBytesBase64", Base64.encode(bytes));
		mapParams.put("filePath", filePath);
		mapParams.put("fileName", fileName);
		JSONObject httpObj = MHttpUtil.post(EasyMConstant.HTTP_FILE_UPLOAD, mapParams);
		if (MHttpUtil.httpRequestSuccess(httpObj)) {
			JSONObject fileInfo = new JSONObject();
			fileInfo.put("fileActualName", httpObj.get("fileActualName"));
			fileInfo.put("fileOriginalName", httpObj.get("fileOriginalName"));
			fileInfo.put("filePath", httpObj.get("filePath"));
			logger.debug("------------上传成功：" + fileInfo.toString());
			return fileInfo;
		}
		return null;
	}

	/**
	 * 检查文件是否存在
	 */
	public static boolean checkFileExist(String filePath, String fileName) {
		boolean fileExist = false;

		if (StringUtil.isNotEmpty(filePath) && StringUtil.isNotEmpty(fileName)) {
			Map<String, Object> mapParams = new HashMap<>();
			mapParams.put("filePath", filePath);
			mapParams.put("fileName", fileName);
			//http请求
			JSONObject httpObj = MHttpUtil.post(EasyMConstant.HTTP_CHECK_FILE_EXIST, mapParams);
			//请求正常
			if (MHttpUtil.httpRequestSuccess(httpObj)) {
				String existFlag = StrUtil.toString(httpObj.get("existFlag"));
				if ("1".equals(existFlag)) {
					fileExist = true;
				}
			}
		}

		return fileExist;
	}

	/**
	 * 执行下载（URL下载）
	 */
	public static void downloadFile(HttpServletResponse response, String fileName, String fileUrl) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		// 连接超时:30s
		int connectTimeout = 30 * 1000;
		// IO超时:1min
		int readTimeout = 1000 * 1000;
		// IO缓冲区:8KB
		byte[] buff = new byte[8 * 1024];

		try {
			URL url = new URL(fileUrl);
			URLConnection conn = url.openConnection();

			conn.setConnectTimeout(connectTimeout);
			conn.setReadTimeout(readTimeout);
			conn.connect();
			InputStream inputStream = conn.getInputStream();

			response.setContentType("application/octet-stream");
			response.setHeader("Content-disposition", "attachment; filename="
					+ new String(fileName.getBytes("utf-8"), "ISO8859-1"));

			bis = new BufferedInputStream(inputStream);
			bos = new BufferedOutputStream(response.getOutputStream());

			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
			bos.flush();   //不可少
			response.flushBuffer();//不可少

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != bis) {
					bis.close();
				}
				if (null != bos) {
					bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
