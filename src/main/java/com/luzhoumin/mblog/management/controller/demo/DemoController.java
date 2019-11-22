package com.luzhoumin.mblog.management.controller.demo;

import com.luzhoumin.mblog.management.service.DemoService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

	@Resource
	private DemoService demoService;

	@RequestMapping("/demo.html")
	public ModelAndView demoPage(HttpServletRequest request, HttpServletResponse response) {
		log.info("DemoController,demoPage:start");
		ModelAndView modelAndView = new ModelAndView("demo/demo");
		log.info("DemoController,demoPage:start");
		return modelAndView;
	}
}
