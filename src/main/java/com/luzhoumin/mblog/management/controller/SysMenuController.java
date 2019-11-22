package com.luzhoumin.mblog.management.controller;

import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.pojo.AjaxJson;
import com.luzhoumin.mblog.management.pojo.MSysMenu;
import com.luzhoumin.mblog.management.service.SysMenuService;
import com.luzhoumin.mblog.management.service.SysTypeDefineService;
import com.luzhoumin.mblog.management.util.HttpServletUtil;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("/sys")
public class SysMenuController {

	@Resource
	SysMenuService sysMenuService;

	@Resource
	SysTypeDefineService sysTypeDefineService;

	@GetMapping("/menu.html")
	public ModelAndView menuListPage(HttpServletRequest request) {
		log.info("SysMenuController,menuListPage:start");

		//SYS_UI_ICON
		Map<String, String> mapParams = new HashMap<>();
		mapParams.put("typeId", "SYS_UI_ICON");
		List<Map<String, Object>> iconTypeList = sysTypeDefineService.getTypeDefineList(mapParams);
		request.setAttribute("iconTypeList", iconTypeList);

		ModelAndView modelAndView = new ModelAndView("menu/menu");
		log.info("SysMenuController,menuListPage:end");
		return modelAndView;
	}

	@GetMapping("/menu.do")
	public void ajaxGetMenuList(HttpServletRequest request, HttpServletResponse response) {
		log.info("SysMenuController,ajaxGetMenuList:start");
		AjaxJson aj = new AjaxJson();
		try {
			List<Map<String, Object>> menuList = sysMenuService.getMenuList();
			aj.setList(menuList);
			aj.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("SysMenuController,ajaxGetList", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		log.info("SysMenuController,ajaxGetMenuList:end");
	}

	@GetMapping("/menuPlant.do")
	public void ajaxGetMenuPlantList(HttpServletRequest request, HttpServletResponse response) {
		log.info("SysMenuController,ajaxGetMenuPlantList:start");
		AjaxJson aj = new AjaxJson();
		try {
			List<Map<String, Object>> menuList = sysMenuService.getMenuList();
			List<Map<String, Object>> menuPlantList = new ArrayList<>();
			findSubMenuAndAddToPlant(menuList, menuPlantList, 0);
			aj.setList(menuPlantList);
			aj.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("SysMenuController,ajaxGetMenuPlantList", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		log.info("SysMenuController,ajaxGetMenuPlantList:end");
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
		log.info("SysMenuController,ajaxAddMenu:start");
		AjaxJson aj = new AjaxJson();
		try {
			aj.setSuccess(sysMenuService.addMenu(menu));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("SysMenuController,ajaxAddMenu", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		log.info("SysMenuController,ajaxAddMenu:end");
	}

	@PutMapping("/menu.do")
	public void ajaxModifyMenu(MSysMenu menu, HttpServletRequest request, HttpServletResponse response) {
		log.info("SysMenuController,ajaxModifyMenu:start");
		AjaxJson aj = new AjaxJson();
		try {
			aj.setSuccess(sysMenuService.modifyMenu(menu));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("SysMenuController,ajaxModifyMenu", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		log.info("SysMenuController,ajaxModifyMenu:end");
	}

	@DeleteMapping("/menu.do")
	public void ajaxDeleteMenu(HttpServletRequest request, HttpServletResponse response) {
		log.info("SysMenuController,ajaxDeleteMenu:start");
		AjaxJson aj = new AjaxJson();
		try {

			String id = request.getParameter("id");
			if (StrUtil.isNotEmpty(id)) {
				aj.setSuccess(sysMenuService.deleteMenu(id));
			} else {
				//参数不全
				aj.setMsg("缺少参数id.");
				aj.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("SysMenuController,ajaxDeleteMenu", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		log.info("SysMenuController,ajaxDeleteMenu:end");
	}
}
