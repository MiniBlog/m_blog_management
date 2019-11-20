package com.luzhoumin.mblog.management.controller;

import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.pojo.AjaxJson;
import com.luzhoumin.mblog.management.pojo.MSysMenu;
import com.luzhoumin.mblog.management.service.MenuService;
import com.luzhoumin.mblog.management.service.TypeDefineService;
import com.luzhoumin.mblog.management.util.HttpServletUtil;
import com.luzhoumin.mblog.management.util.ConvertUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on September 24, 2019
 * Description:
 *
 * @author <a href="mailto:zmlu1996@gmail.com">Jacob Lu</a>
 * @since 1.8
 */
@RestController
public class MenuController {
	private static Logger logger = LoggerFactory.getLogger(MenuController.class);

	@Resource
	MenuService menuService;

	@Resource
	TypeDefineService typeDefineService;

	@GetMapping("/menu.html")
	public ModelAndView list(HttpServletRequest request) {
		logger.info("**************** MenuController,list:start ****************");

		//SYS_UI_ICON
		Map<String, String> mapParams = new HashMap<>();
		mapParams.put("typeId", "SYS_UI_ICON");
		List<Map<String, Object>> iconTypeList = typeDefineService.getTypeDefineList(mapParams);
		request.setAttribute("iconTypeList", iconTypeList);

		logger.info("**************** MenuController,list:end ****************");
		return new ModelAndView("menu/menu");
	}

	@GetMapping("/menu.do")
	public void ajaxGetList(HttpServletRequest request, HttpServletResponse response) {
		logger.info("**************** MenuController,ajaxGetList:start ****************");
		AjaxJson aj = new AjaxJson();
		try {
			Map<String, String> paramMap = ConvertUtil.requestToMap(request);
			List<Map<String, Object>> menuList = menuService.getMenuList();
			aj.setList(menuList);
			aj.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("MenuController,ajaxGetList", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		logger.info("**************** MenuController,ajaxGetList:end ****************");
	}

	@GetMapping("/menuPlant.do")
	public void ajaxGetPlantList(HttpServletRequest request, HttpServletResponse response) {
		logger.info("**************** MenuController,ajaxGetPlantList:start ****************");
		AjaxJson aj = new AjaxJson();
		try {
			List<Map<String, Object>> menuList = menuService.getMenuList();
			List<Map<String, Object>> menuPlantList = new ArrayList<>();
			findSubMenuAndAddToPlant(menuList, menuPlantList, 0);
			aj.setList(menuPlantList);
			aj.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("MenuController,ajaxGetList", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		logger.info("**************** MenuController,ajaxGetPlantList:end ****************");
	}

	/**
	 * 将子菜单展开到平铺菜单
	 *
	 * @param menuList
	 * @param menuPlantList
	 */
	private void findSubMenuAndAddToPlant(List<Map<String, Object>> menuList, List<Map<String, Object>> menuPlantList, int level) {
		int orgLevel = level;
		for (Map<String, Object> menu : menuList) {
			menu.put("_title", StrUtil.repeat("--", level) + menu.get("_title"));
			menuPlantList.add(menu);
			List<Map<String, Object>> children = (List<Map<String, Object>>) menu.get("children");
			if (children != null && children.size() > 0) {
				level++;
				findSubMenuAndAddToPlant(children, menuPlantList, level);
			}
			level = orgLevel;
		}
	}

	@PostMapping("/menu.do")
	public void ajaxAddMenu(MSysMenu menu, HttpServletResponse response) {
		logger.info("**************** MenuController,ajaxAddMenu:start ****************");
		AjaxJson aj = new AjaxJson();
		try {
			aj.setSuccess(menuService.addMenu(menu));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("MenuController,ajaxAddMenu", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		logger.info("**************** MenuController,ajaxAddMenu:end ****************");
	}

	@PutMapping("/menu.do")
	public void ajaxModifyMenu(MSysMenu menu, HttpServletRequest request, HttpServletResponse response) {
		logger.info("**************** MenuController,ajaxModifyMenu:start ****************");
		AjaxJson aj = new AjaxJson();
		try {
			aj.setSuccess(menuService.modifyMenu(menu));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("MenuController,ajaxModifyMenu", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		logger.info("**************** MenuController,ajaxModifyMenu:end ****************");
	}

	@DeleteMapping("/menu.do")
	public void ajaxDeleteMenu(HttpServletRequest request, HttpServletResponse response) {
		logger.info("**************** MenuController,ajaxDeleteMenu:start ****************");
		AjaxJson aj = new AjaxJson();
		try {

			String uuid = request.getParameter("uuid");
			if (StrUtil.isNotEmpty(uuid)) {
				aj.setSuccess(menuService.deleteMenu(uuid));
			} else {
				//参数不全
				aj.setMsg("缺少参数uuid.");
				aj.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("MenuController,ajaxDeleteMenu", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		logger.info("**************** MenuController,ajaxDeleteMenu:end ****************");
	}
}
