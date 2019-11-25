package com.luzhoumin.mblog.management.controller;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.pojo.AjaxJson;
import com.luzhoumin.mblog.management.pojo.TMbModule;
import com.luzhoumin.mblog.management.service.ModuleService;
import com.luzhoumin.mblog.management.service.SequenceService;
import com.luzhoumin.mblog.management.util.ConvertUtil;
import com.luzhoumin.mblog.management.util.HttpServletUtil;
import com.luzhoumin.mblog.management.util.PageHelperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
@RestController
public class ModuleController {

	@Resource
	ModuleService moduleService;
	@Resource
	SequenceService sequenceService;

	@RequestMapping("/add-module.html")
	public ModelAndView addModulePage(HttpServletRequest request) {
		log.info("ModuleController,addModulePage:start");
		log.info("ModuleController,addModulePage:start");
		return new ModelAndView("module/add_module");
	}

	@RequestMapping("/module-list.html")
	public ModelAndView moduleListPage(HttpServletRequest request) {
		log.info("ModuleController,moduleListPage:start");
		log.info("ModuleController,moduleListPage:start");
		return new ModelAndView("module/module_list");
	}

	@GetMapping("/module.do")
	public void ajaxGetList(HttpServletRequest request, HttpServletResponse response) {
		log.info("ModuleController,ajaxGetList:start");
		AjaxJson aj = new AjaxJson();
		try {
			Map<String, String> paramMap = ConvertUtil.requestToMap(request);
			Map<String, Object> data = moduleService.getModuleList(paramMap, PageHelperUtil.getPageNum(request), PageHelperUtil.getPageSize(request));
			aj.setMap(data);
			aj.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ModuleController,ajaxGetList", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		log.info("ModuleController,ajaxGetList:end");
	}

	@DeleteMapping("/module.do")
	public void ajaxDeleteModel(HttpServletRequest request, HttpServletResponse response) {
		log.info("ModuleController,ajaxDeleteModel:start");
		AjaxJson aj = new AjaxJson();
		try {
			String id = request.getParameter("id");
			if (StrUtil.isNotEmpty(id)) {
				TMbModule moduleInfo = moduleService.getModuleInfoById(NumberUtil.parseInt(id));
				if (moduleInfo == null) {
					//用户不存在
					aj.setMsg("模块不存在");
					aj.setSuccess(false);
				} else {
					aj.setSuccess(moduleService.deleteModule(moduleInfo));
				}
			} else {
				//参数不全
				aj.setMsg("缺少参数id.");
				aj.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ModuleController,ajaxDeleteModel", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		log.info("ModuleController,ajaxDeleteModel:end");
	}

	@PostMapping("/module.do")
	public void ajaxAddModule(TMbModule module, HttpServletResponse response) {
		log.info("ModuleController,ajaxAddModule:start");
		AjaxJson aj = new AjaxJson();
		try {
			String uid = sequenceService.getSequence("MODULE_ID");
			module.setUid(uid);
			boolean b = moduleService.addModule(module);
			aj.setSuccess(b);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ModuleController,ajaxAddModule", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		log.info("ModuleController,ajaxAddModule:end");
	}

	@PutMapping("/module.do")
	public void ajaxModifyModule(TMbModule module, HttpServletRequest request, HttpServletResponse response) {
		log.info("ModuleController,ajaxModifyModule:start");
		AjaxJson aj = new AjaxJson();
		try {
			aj.setSuccess(moduleService.modifyModule(module));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ModuleController,ajaxModifyModule", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		log.info("ModuleController,ajaxModifyModule:end");
	}
}
