package com.luzhoumin.mblog.management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.luzhoumin.mblog.management.mapper")
public class MBlogManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MBlogManagementApplication.class, args);
	}

}
