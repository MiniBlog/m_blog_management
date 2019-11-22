package com.luzhoumin.mblog.management.controller.demo;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoPicUploadController {

	@RequestMapping("/picUpload.html")
	public ModelAndView picUploadPage(HttpServletRequest request, HttpServletResponse response) {
		log.info("DemoController,picUploadPage:start");
		ModelAndView modelAndView = new ModelAndView("demo/picUpload");
		log.info("DemoController,picUploadPage:end");
		return modelAndView;
	}
}
