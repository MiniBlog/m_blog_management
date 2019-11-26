package com.luzhoumin.mblog.management.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.template.Template;
import cn.hutool.extra.template.TemplateEngine;
import cn.hutool.extra.template.engine.thymeleaf.ThymeleafEngine;
import cn.hutool.json.JSONUtil;
import com.luzhoumin.mblog.management.pojo.AjaxJson;
import com.luzhoumin.mblog.management.pojo.TMbModuleWithBLOBs;
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
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class ModuleController {

	@Resource
	ModuleService moduleService;
	@Resource
	SequenceService sequenceService;

	@RequestMapping("/edit-module.html")
	public ModelAndView addModulePage(HttpServletRequest request) {
		log.info("ModuleController,addModulePage:start");
		log.info("ModuleController,addModulePage:start");
		return new ModelAndView("module/edit-module");
	}

	@RequestMapping("/module-list.html")
	public ModelAndView moduleListPage(HttpServletRequest request) {
		log.info("ModuleController,moduleListPage:start");
		log.info("ModuleController,moduleListPage:start");
		return new ModelAndView("module/module-list");
	}

	@GetMapping("/module-list.do")
	public void ajaxGetModuleList(HttpServletRequest request, HttpServletResponse response) {
		log.info("ModuleController,ajaxGetModuleList:start");
		AjaxJson aj = new AjaxJson();
		try {
			Map<String, String> paramMap = ConvertUtil.requestToMap(request);
			Map<String, Object> data = moduleService.getModuleList(paramMap, PageHelperUtil.getPageNum(request), PageHelperUtil.getPageSize(request));
			aj.setMap(data);
			aj.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ModuleController,ajaxGetModuleList", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		log.info("ModuleController,ajaxGetModuleList:end");
	}

	@GetMapping("/module.do")
	public void ajaxGetModule(@RequestParam("moduleId") int moduleId, HttpServletResponse response) {
		log.info("ModuleController,ajaxGetModule:start");
		AjaxJson aj = new AjaxJson();
		try {
			TMbModuleWithBLOBs tMbModuleWithBLOBs = moduleService.getModule(moduleId);
			Map<String, Object> moduleBeanMap = BeanUtil.beanToMap(tMbModuleWithBLOBs);
			aj.setMap(moduleBeanMap);
			aj.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ModuleController,ajaxGetModule", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		log.info("ModuleController,ajaxGetModule:end");
	}

	@DeleteMapping("/module.do")
	public void ajaxDeleteModel(HttpServletRequest request, HttpServletResponse response) {
		log.info("ModuleController,ajaxDeleteModel:start");
		AjaxJson aj = new AjaxJson();
		try {
			String id = request.getParameter("id");
			if (StrUtil.isNotEmpty(id)) {
				TMbModuleWithBLOBs tMbModuleWithBLOBs = moduleService.getModuleInfoById(NumberUtil.parseInt(id));
				if (tMbModuleWithBLOBs == null) {
					//用户不存在
					aj.setMsg("模块不存在");
					aj.setSuccess(false);
				} else {
					aj.setSuccess(moduleService.deleteModule(tMbModuleWithBLOBs));
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
	public void ajaxAddModule(TMbModuleWithBLOBs tMbModuleWithBLOBs, HttpServletResponse response) {
		log.info("ModuleController,ajaxAddModule:start");
		AjaxJson aj = new AjaxJson();
		try {
			String uid = sequenceService.getSequence("MODULE_ID");
			tMbModuleWithBLOBs.setUid(uid);
			boolean b = moduleService.addModule(tMbModuleWithBLOBs);
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
	public void ajaxModifyModule(TMbModuleWithBLOBs tMbModuleWithBLOBs, HttpServletRequest request, HttpServletResponse response) {
		log.info("ModuleController,ajaxModifyModule:start");
		AjaxJson aj = new AjaxJson();
		try {
			aj.setSuccess(moduleService.modifyModule(tMbModuleWithBLOBs));
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ModuleController,ajaxModifyModule", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		log.info("ModuleController,ajaxModifyModule:end");
	}

	@RequestMapping("/preview-module.html")
	public ModelAndView preview(@RequestParam("moduleId") int moduleId, @RequestParam("previewParam") String previewParam) {
		TMbModuleWithBLOBs tMbModuleWithBLOBs = moduleService.getModule(moduleId);
		String templateStr = tMbModuleWithBLOBs.getTemplate();
		String cssStr = tMbModuleWithBLOBs.getCss();
		String jsStr = tMbModuleWithBLOBs.getJs();
		previewParam = Base64.decodeStr(previewParam);
		log.error(previewParam);
		Map<String, Object> paramMap = JSONUtil.toBean(previewParam, new TypeReference<Map<String, Object>>() {
		}, true);
		TemplateEngine engine = new ThymeleafEngine();
		Template template = engine.getTemplate(templateStr);
		String result = template.render(paramMap);

		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("body", result);
		modelMap.put("js", jsStr);
		modelMap.put("css", cssStr);
		return new ModelAndView("module/preview-module", modelMap);
	}
}
