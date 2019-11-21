package com.luzhoumin.mblog.management.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created on September 23, 2019
 * Description:
 *
 * @author <a href="mailto:zmlu1996@gmail.com">Jacob Lu</a>
 * @since 1.8
 */
public interface SysMenuMapper {
	//获取主菜单
	List<Map<String, Object>> getRootMenuList();

	//获取所有菜单-不分级
	List<Map<String, Object>> getPlainMenuList();

	//根据uuid获取子菜单
	List<Map<String, Object>> getSubMenuListByParentId(String parentId);
}
