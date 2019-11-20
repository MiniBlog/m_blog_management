package com.luzhoumin.mblog.management.controller;

import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.pojo.AjaxJson;
import com.luzhoumin.mblog.management.service.FileService;
import com.luzhoumin.mblog.management.util.HttpServletUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/file")
public class FileController {

	private static Logger logger = LoggerFactory.getLogger(FileController.class);

	@Resource
	private FileService fileService;

	@RequestMapping("/upload.do")
	public void upload(HttpServletRequest request, HttpServletResponse response) {
		logger.info("**********upload 开始**********");
		AjaxJson aj = new AjaxJson();

		Map<String, Object> fileInfo = fileService.uploadFile(request);
		if ("true".equals(fileInfo.get("success"))) {
			//上传成功
			aj.setSuccess(true);
			aj.setMap(fileInfo);
		}else{
			//上传失败
			aj.setSuccess(false);
			aj.setMsg(StrUtil.toString(fileInfo.get("message")));
		}

		HttpServletUtil.ajaxResponse(response, aj);
		logger.info("**********upload 结束**********");
	}

	@RequestMapping("/download.do")
	public void download(HttpServletRequest request, HttpServletResponse response) {
		logger.info("**********download 开始**********");

		fileService.downloadFile(request, response);

		logger.info("**********download 结束**********");
	}

}
