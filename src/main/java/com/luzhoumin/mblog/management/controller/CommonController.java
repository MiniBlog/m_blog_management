package com.luzhoumin.mblog.management.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CommonController {
	private static Logger logger = LoggerFactory.getLogger(CommonController.class);

	/**
	 * 跳转404
	 */
	@RequestMapping("/error/404.html")
	public ModelAndView error404() {
		logger.info("**************** CommonController,error404:start ****************");
		logger.info("**************** CommonController,error404:end ****************");
		return new ModelAndView("/error/404");
	}

	/**
	 * 跳转500
	 */
	@RequestMapping("/error/500.html")
	public ModelAndView error500() {
		logger.info("**************** CommonController,error500:start ****************");
		logger.info("**************** CommonController,error500:end ****************");
		return new ModelAndView("/error/500");
	}
}
