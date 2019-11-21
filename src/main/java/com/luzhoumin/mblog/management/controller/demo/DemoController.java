package com.luzhoumin.mblog.management.controller.demo;

import com.luzhoumin.mblog.management.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 九月 19, 2019
 * Description:
 *
 * @author <a href="mailto:zmlu1996@gmail.com">Jacob Lu</a>
 * @since 1.8
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

	private static Logger logger = LoggerFactory.getLogger(DemoController.class);
	@Resource
	private DemoService demoService;
	
	@RequestMapping("/demo.html")
	public ModelAndView demo(HttpServletRequest request, HttpServletResponse response){
		logger.info("**************** DemoController,demo:start ****************");
		logger.info("**************** DemoController,demo:start ****************");
		return new ModelAndView("demo/demo");
	}
}
