package com.luzhoumin.mblog.management.controller;

import com.luzhoumin.mblog.management.pojo.AjaxJson;
import com.luzhoumin.mblog.management.service.SysLogRequestService;
import com.luzhoumin.mblog.management.util.ConvertUtil;
import com.luzhoumin.mblog.management.util.HttpServletUtil;
import com.luzhoumin.mblog.management.util.PageHelperUtil;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("/sys/log")
public class SysLogRequestController {

	@Resource
	SysLogRequestService sysLogRequestService;

	@GetMapping("/request.html")
	public ModelAndView requestListPage() {
		log.info("SysLogRequestController,requestListPage:start");
		ModelAndView modelAndView = new ModelAndView("log/request");
		log.info("SysLogRequestController,requestListPage:end");
		return new ModelAndView("log/request");
	}

	@GetMapping("/request.do")
	public void ajaxGetRequestLogList(HttpServletRequest request, HttpServletResponse response) {
		log.info("SysLogRequestController,ajaxGetRequestLogList:start");
		AjaxJson aj = new AjaxJson();
		try {
			Map<String, String> paramMap = ConvertUtil.requestToMap(request);
			Map<String, Object> data = sysLogRequestService.getRequestLogList(paramMap, PageHelperUtil.getPageNum(request), PageHelperUtil.getPageSize(request));
			aj.setMap(data);
			aj.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("SysLogRequestController,ajaxGetRequestLogList", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		log.info("SysLogRequestController,ajaxGetRequestLogList:end");
	}
}
