package com.luzhoumin.mblog.management.controller;

import cn.hutool.json.JSONUtil;
import com.luzhoumin.mblog.management.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class IndexController {

	@Resource
	SysMenuService sysMenuService;

	@RequestMapping("/index.html")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		log.info("IndexController,index:start");
		List<Map<String, Object>> menuList = sysMenuService.getMenuList();
		request.setAttribute("menuList", JSONUtil.parseArray(menuList));
		request.setAttribute("plainMenuMap", JSONUtil.parseObj(sysMenuService.getPlainMenuMap()));
		ModelAndView modelAndView = new ModelAndView("index");
		log.info("IndexController,index:end");
		return modelAndView;
	}
}
