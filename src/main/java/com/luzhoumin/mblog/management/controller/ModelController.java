package com.luzhoumin.mblog.management.controller;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.pojo.AjaxJson;
import com.luzhoumin.mblog.management.pojo.MSysModel;
import com.luzhoumin.mblog.management.service.ModelService;
import com.luzhoumin.mblog.management.util.ConvertUtil;
import com.luzhoumin.mblog.management.util.HttpServletUtil;
import com.luzhoumin.mblog.management.util.PageHelperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
@RestController
public class ModelController {

	@Resource
	ModelService modelService;

	@RequestMapping("/add-model.html")
	public ModelAndView addModelPage(HttpServletRequest request) {
		log.info("ModelController,addModelPage:start");
		log.info("ModelController,addModelPage:start");
		return new ModelAndView("model/add_model");
	}

	@RequestMapping("/model-list.html")
	public ModelAndView modelListPage(HttpServletRequest request) {
		log.info("ModelController,modelListPage:start");
		log.info("ModelController,modelListPage:start");
		return new ModelAndView("model/model_list");
	}

	@GetMapping("/model.do")
	public void ajaxGetList(HttpServletRequest request, HttpServletResponse response) {
		log.info("ModelController,ajaxGetList:start");
		AjaxJson aj = new AjaxJson();
		try {
			Map<String, String> paramMap = ConvertUtil.requestToMap(request);
			Map<String, Object> data = modelService.getModelList(paramMap, PageHelperUtil.getPageNum(request), PageHelperUtil.getPageSize(request));
			aj.setMap(data);
			aj.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ModelController,ajaxGetList", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		log.info("ModelController,ajaxGetList:end");
	}

	@DeleteMapping("/model.do")
	public void ajaxDeleteModel(HttpServletRequest request, HttpServletResponse response) {
		log.info("ModelController,ajaxDeleteModel:start");
		AjaxJson aj = new AjaxJson();
		try {
			String id = request.getParameter("id");
			if (StrUtil.isNotEmpty(id)) {
				MSysModel modelInfo = modelService.getModelInfoById(NumberUtil.parseInt(id));
				if (modelInfo == null) {
					//用户不存在
					aj.setMsg("模块不存在");
					aj.setSuccess(false);
				} else {
					aj.setSuccess(modelService.deleteModel(modelInfo));
				}
			} else {
				//参数不全
				aj.setMsg("缺少参数id.");
				aj.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("ModelController,ajaxDeleteModel", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		log.info("ModelController,ajaxDeleteModel:end");
	}
}
