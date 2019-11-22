package com.luzhoumin.mblog.management.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
public class CommonController {

	/**
	 * 跳转404
	 */
	@RequestMapping("/error/404.html")
	public ModelAndView error404Page() {
		log.info("CommonController,error404Page:start");
		ModelAndView modelAndView = new ModelAndView("/error/404");
		log.info("CommonController,error404Page:end");
		return modelAndView;
	}

	/**
	 * 跳转500
	 */
	@RequestMapping("/error/500.html")
	public ModelAndView error500Page() {
		log.info("CommonController,error500Page:start");
		ModelAndView modelAndView = new ModelAndView("/error/500");
		log.info("CommonController,error500Page:end");
		return modelAndView;
	}
}
