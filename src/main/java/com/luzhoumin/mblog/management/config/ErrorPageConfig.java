package com.luzhoumin.mblog.management.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Slf4j
@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {

	@Override
	public void registerErrorPages(ErrorPageRegistry registry) {
		log.info("Error配置开始");
		ErrorPage[] errorPages = new ErrorPage[2];
		errorPages[0] = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404.html");
		errorPages[1] = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500.html");

		registry.addErrorPages(errorPages);
		log.info("Error配置结束");
	}
}
