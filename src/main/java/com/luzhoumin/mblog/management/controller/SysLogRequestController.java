package com.luzhoumin.mblog.management.controller;

import com.luzhoumin.mblog.management.pojo.AjaxJson;
import com.luzhoumin.mblog.management.service.LogService;
import com.luzhoumin.mblog.management.util.ConvertUtil;
import com.luzhoumin.mblog.management.util.HttpServletUtil;
import com.luzhoumin.mblog.management.util.PageHelperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created on October 10, 2019
 * Description:
 *
 * @author <a href="mailto:zmlu1996@gmail.com">Jacob Lu</a>
 * @since 1.8
 */
@RestController
@RequestMapping("/sys/log")
public class SysLogRequestController {
	private static Logger logger = LoggerFactory.getLogger(SysLogRequestController.class);

	@Resource
	LogService logService;

	@GetMapping("/request.html")
	public ModelAndView requestList() {
		logger.info("**************** SysLogRequestController,requestList:start ****************");
		logger.info("**************** SysLogRequestController,requestList:end ****************");
		return new ModelAndView("log/request");
	}

	@GetMapping("/request.do")
	public void ajaxGetRequestLogList(HttpServletRequest request, HttpServletResponse response) {
		logger.info("**************** SysLogRequestController,ajaxGetRequestLogList:start ****************");
		AjaxJson aj = new AjaxJson();
		try {
			Map<String, String> paramMap = ConvertUtil.requestToMap(request);
			Map<String, Object> data = logService.getRequestLogList(paramMap, PageHelperUtil.getPageNum(request), PageHelperUtil.getPageSize(request));
			aj.setMap(data);
			aj.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("SysLogRequestController,ajaxGetRequestLogList", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		logger.info("**************** SysLogRequestController,ajaxGetRequestLogList:end ****************");
	}
}
