package com.luzhoumin.mblog.management.controller.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/demo")
public class DemoPicUploadController {
	private static Logger logger = LoggerFactory.getLogger(DemoPicUploadController.class);

	@RequestMapping("/picUpload.html")
	public ModelAndView demo(HttpServletRequest request, HttpServletResponse response) {
		logger.info("**************** DemoController,demo:start ****************");
		logger.info("**************** DemoController,demo:start ****************");
		return new ModelAndView("demo/picUpload");
	}
}
