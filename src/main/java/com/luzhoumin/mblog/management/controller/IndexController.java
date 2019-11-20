package com.luzhoumin.mblog.management.controller;

import cn.hutool.json.JSONUtil;
import com.luzhoumin.mblog.management.service.SysMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
public class IndexController {

	private static Logger logger = LoggerFactory.getLogger(IndexController.class);
	@Resource
	SysMenuService sysMenuService;

	@RequestMapping("/index.html")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		logger.info("**************** IndexController,index:start ****************");
		List<Map<String, Object>> menuList = sysMenuService.getMenuList();
		request.setAttribute("menuList", JSONUtil.parseArray(menuList));
		request.setAttribute("plainMenuMap", JSONUtil.parseObj(sysMenuService.getPlainMenuMap()));
		logger.info("**************** IndexController,index:end ****************");
		return new ModelAndView("index");
	}
}
