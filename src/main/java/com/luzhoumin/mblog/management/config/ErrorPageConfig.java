package com.luzhoumin.mblog.management.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.server.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {

	private static Logger logger = LoggerFactory.getLogger(ErrorPageConfig.class);

	@Override
	public void registerErrorPages(ErrorPageRegistry registry) {
		logger.info("Error配置开始");
		ErrorPage[] errorPages = new ErrorPage[2];
		errorPages[0] = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404.html");
		errorPages[1] = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500.html");

		registry.addErrorPages(errorPages);
		logger.info("Error配置结束");
	}
}
