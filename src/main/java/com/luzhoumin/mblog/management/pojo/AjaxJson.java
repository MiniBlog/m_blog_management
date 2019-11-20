package com.luzhoumin.mblog.management.pojo;

import cn.hutool.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * $.ajax后需要接受的JSON
 *
 * @author
 */
public class AjaxJson {

	JSONObject jsonObject = new JSONObject();

	public JSONObject getJsonObject() {
		if (jsonObject.get("success") == null) {
			jsonObject.put("success", true);
		}
		return jsonObject;
	}

	/**
	 * 以下为AjaxJson可容纳类型
	 */
	public void setStr(String str) {
		jsonObject.put("str", str);
	}

	public void setObj(Object obj) {
		jsonObject.put("obj", obj);
	}

	public void setMsg(String msg) {
		jsonObject.put("msg", msg);
	}

	public void setSuccess(boolean success) {
		jsonObject.put("success", success);
	}

	public void setMap(Map map) {
		jsonObject.put("map", map);
	}

	public void setList(List list) {
		jsonObject.put("list", list);
	}
	/** 以上为AjaxJson可容纳类型 */
}
