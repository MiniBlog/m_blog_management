package com.luzhoumin.mblog.management.controller;

import com.luzhoumin.mblog.management.pojo.AjaxJson;
import com.luzhoumin.mblog.management.service.DemoService;
import com.luzhoumin.mblog.management.util.HttpServletUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created on 九月 19, 2019
 * Description:
 *
 * @author <a href="mailto:zmlu1996@gmail.com">Jacob Lu</a>
 * @since 1.8
 */
@RestController
@RequestMapping("/demo")
public class DemoConroller {

	private static Logger logger = LoggerFactory.getLogger(DemoConroller.class);
	@Resource
	private DemoService demoService;

	@GetMapping("/get_list.do")
	public void getList(HttpServletRequest request, HttpServletResponse response) {
		logger.info("**************** DemoConroller,getList:start ****************");
		AjaxJson aj = new AjaxJson();
		try {
			List<Map<String, Object>> list = demoService.getList();
			aj.setObj(list);
			aj.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("DemoConroller,getList", e);
			aj.setSuccess(false);
		}
		logger.info("**************** DemoConroller,getList:end ****************");
		HttpServletUtil.ajaxResponse(response, aj);
	}
}
