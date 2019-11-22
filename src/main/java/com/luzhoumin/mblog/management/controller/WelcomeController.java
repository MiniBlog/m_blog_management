package com.luzhoumin.mblog.management.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
public class WelcomeController {

	@RequestMapping("welcome.html")
	public ModelAndView welcomePage() {
		log.info("WelcomeController,welcomePage:start");
		log.info("WelcomeController,welcomePage:end");
		return new ModelAndView("welcome/welcome");
	}
}
