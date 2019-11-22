package com.luzhoumin.mblog.management.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.luzhoumin.mblog.management.pojo.AjaxJson;
import com.luzhoumin.mblog.management.service.MService;
import com.luzhoumin.mblog.management.util.ConvertUtil;
import com.luzhoumin.mblog.management.util.HttpServletUtil;
import com.luzhoumin.mblog.management.util.PageHelperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on October 11, 2019
 * Description:
 *
 * @author <a href="mailto:zmlu1996@gmail.com">Jacob Lu</a>
 * @since 1.8
 */
@Slf4j
@RestController
@RequestMapping("/M")
public class M_CRUD_common_Controller {

	@Resource
	MService mService;

	@GetMapping("/{$keyWord}.html")
	public ModelAndView crudCommonList(HttpServletRequest request, @PathVariable String $keyWord) {
		log.info("M_CRUD_common_Controller,crudCommonList," + $keyWord + ":start");
		JSONObject $filterForm = new JSONObject();

		// 1.获取表的列
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("$keyWord", $keyWord);
		paramMap.put("$tableName", "m_" + $keyWord);
		List<Map<String, Object>> $tableColumns = mService.getTableColumns(paramMap);

		for (Map<String, Object> $tableColumn : $tableColumns) {

//			// 2.整理数据(添加显示宽度)
//			String dataType = StrUtil.toString($tableColumn.get("DATA_TYPE"));
//			if ("varchar".equals(dataType)) {//VARCHAR
//				int characterMaximumLength = ((Number) $tableColumn.get("CHARACTER_MAXIMUM_LENGTH")).intValue() * 4;
//				$tableColumn.put("column_display_width", characterMaximumLength + "");
//			} else if ("datetime".equals(dataType)) {//DATETIME
//				$tableColumn.put("column_display_width", 300);
//			} else if ("date".equals(dataType)) {//DATE
//				$tableColumn.put("column_display_width", 180);
//			} else {
//				$tableColumn.put("column_display_width", 100);
//			}
			$tableColumn.put("column_display_width", 300);

			// 3.根据列生成filterForm
			String columnName = StrUtil.toString($tableColumn.get("COLUMN_NAME"));
			$filterForm.put(columnName, "");

		}

		// 4.填充数据
		request.setAttribute("tableColumns", $tableColumns);
		request.setAttribute("filterForm", $filterForm);
		request.setAttribute("keyWord", $keyWord);

		log.info("M_CRUD_common_Controller,crudCommonList," + $keyWord + ":end");
		return new ModelAndView("M/CRUD_common");
	}

	@GetMapping("/{$keyWord}.do")
	public void ajaxGetCrudCommonList(HttpServletRequest request, HttpServletResponse response, @PathVariable String $keyWord) {
		log.info("M_CRUD_common_Controller,ajaxGetCrudCommonList," + $keyWord + ":start");
		AjaxJson aj = new AjaxJson();
		try {

			// 1.获取表的列
			Map<String, String> paramMap = ConvertUtil.requestToMap(request);
			paramMap.put("$keyWord", "$keyWord");
			paramMap.put("$tableName", "m_" + $keyWord);
			List<Map<String, Object>> $tableColumns = mService.getTableColumns(paramMap);
			StringBuilder $select = new StringBuilder();

			// 2.生成Select语句 (格式化时间)
			for (Map<String, Object> $tableColumn : $tableColumns) {
				String dataType = StrUtil.toString($tableColumn.get("DATA_TYPE"));
				String columnName = StrUtil.toString($tableColumn.get("COLUMN_NAME"));
				if ("datetime".equals(dataType)) {//DATETIME
					$select.append("DATE_FORMAT(").append(columnName).append(",'%Y-%m-%d %H:%i:%s') as ").append(columnName).append(",");
				} else if ("date".equals(dataType)) {//DATE
					$select.append("DATE_FORMAT(").append(columnName).append(",'%Y-%m-%d') as ").append(columnName).append(",");
				} else {
					$select.append(columnName).append(",");
				}
			}
			$select = new StringBuilder($select.substring(0, $select.length() - 1));
			paramMap.put("$select", $select.toString());

			// 3.获取数据
			Map<String, Object> data = mService.getList(paramMap, PageHelperUtil.getPageNum(request), PageHelperUtil.getPageSize(request));

			aj.setMap(data);
			aj.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("M_CRUD_common_Controller,ajaxGetCrudCommonList", e);
			aj.setSuccess(false);
			aj.setMsg(e.getMessage());
		}
		HttpServletUtil.ajaxResponse(response, aj);
		log.info("M_CRUD_common_Controller,ajaxGetCrudCommonList," + $keyWord + ":end");
	}
}
