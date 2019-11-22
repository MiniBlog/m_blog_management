package com.luzhoumin.mblog.management.controller;

import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.pojo.AjaxJson;
import com.luzhoumin.mblog.management.service.FileService;
import com.luzhoumin.mblog.management.util.HttpServletUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {

	@Resource
	private FileService fileService;

	@RequestMapping("/upload.do")
	public void upload(HttpServletRequest request, HttpServletResponse response) {
		log.info("FileController,upload:start");
		AjaxJson aj = new AjaxJson();
		Map<String, Object> fileInfo = fileService.uploadFile(request);
		if ("true".equals(fileInfo.get("success"))) {
			//上传成功
			aj.setSuccess(true);
			aj.setMap(fileInfo);
		} else {
			//上传失败
			aj.setSuccess(false);
			aj.setMsg(StrUtil.toString(fileInfo.get("message")));
		}
		HttpServletUtil.ajaxResponse(response, aj);
		log.info("FileController,upload:end");
	}

	@RequestMapping("/download.do")
	public void download(HttpServletRequest request, HttpServletResponse response) {
		log.info("FileController,download:start");
		fileService.downloadFile(request, response);
		log.info("FileController,download:end");
	}

}
