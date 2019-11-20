package com.luzhoumin.mblog.management.service;

import com.luzhoumin.mblog.management.pojo.MSysMenu;

import java.util.List;
import java.util.Map;

/**
 * Created on September 23, 2019
 * Description:
 *
 * @author <a href="mailto:zmlu1996@gmail.com">Jacob Lu</a>
 * @since 1.8
 */
public interface SysMenuService {
	//获取菜单
	List<Map<String, Object>> getMenuList();

	//获取菜单不分级Map， key：_key，value：map
	Map<String, Map<String, Object>> getPlainMenuMap();

	boolean addMenu(MSysMenu menu);

	boolean modifyMenu(MSysMenu menu);

	MSysMenu getMenuInfoByUuid(String uuid);

	boolean deleteMenu(String uuid);
}
