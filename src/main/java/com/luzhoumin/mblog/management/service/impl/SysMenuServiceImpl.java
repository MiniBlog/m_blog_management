package com.luzhoumin.mblog.management.service.impl;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.mapper.MenuMapper;
import com.luzhoumin.mblog.management.mapper.generate.TMbMenuMapper;
import com.luzhoumin.mblog.management.pojo.TMbMenu;
import com.luzhoumin.mblog.management.service.SysMenuService;
import com.luzhoumin.mblog.management.util.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on September 23, 2019
 * Description:
 *
 * @author <a href="mailto:zmlu1996@gmail.com">Jacob Lu</a>
 * @since 1.8
 */
@Slf4j
@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Resource
	MenuMapper menuMapper;
	@Resource
	TMbMenuMapper tMbMenuMapper;

	@Override
	public List<Map<String, Object>> getMenuList() {
		log.info("MenuServiceImpl,getMenuList:start");
		List<Map<String, Object>> rootMenuList = menuMapper.getRootMenuList();
		for (Map<String, Object> rootMenu : rootMenuList) {
			findSubMenuAndAdd(rootMenu);
		}
		log.info("MenuServiceImpl,getMenuList:end");
		return rootMenuList;
	}

	@Override
	public Map<String, Map<String, Object>> getPlainMenuMap() {
		log.info("MenuServiceImpl,getPlainMenuMap:start");
		Map<String, Map<String, Object>> plainMenuMap = new LinkedHashMap<>();
		List<Map<String, Object>> plainMenuList = menuMapper.getPlainMenuList();
		for (Map<String, Object> row : plainMenuList) {
			plainMenuMap.put(String.valueOf(row.get("_key")), row);
		}
		log.info("MenuServiceImpl,getPlainMenuMap:end");
		return plainMenuMap;
	}

	@Override
	public boolean addMenu(TMbMenu menu) {
		log.info("MenuServiceImpl,addMenu:start");
		try {
			String loginUser = StrUtil.toString(SessionUtil.getSessionLoginUserName());
			Date now = new Date();

			menu.setCreateBy(loginUser);
			menu.setCreateDate(now);
			menu.setUpdateBy(loginUser);
			menu.setUpdateDate(now);

			tMbMenuMapper.insertSelective(menu);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("MenuServiceImpl,addMenu", e);
			return false;
		}
		log.info("MenuServiceImpl,addMenu:end");
		return true;
	}

	@Override
	public boolean modifyMenu(TMbMenu menu) {
		log.info("MenuServiceImpl,modifyMenu:start");
		try {
			String loginUser = StrUtil.toString(SessionUtil.getSessionLoginUserName());
			Date now = new Date();

			menu.setUpdateBy(loginUser);
			menu.setUpdateDate(now);

			tMbMenuMapper.updateByPrimaryKeySelective(menu);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("MenuServiceImpl,modifyMenu", e);
			return false;
		}
		log.info("MenuServiceImpl,modifyMenu:end");
		return true;
	}

	@Override
	public boolean deleteMenu(String id) {
		log.info("MenuServiceImpl,deleteMenu:start");
		try {
			String loginUser = StrUtil.toString(SessionUtil.getSessionLoginUserName());
			Date now = new Date();

			TMbMenu menu = new TMbMenu();
			menu.setId(NumberUtil.parseInt(id));
			menu.setUpdateBy(loginUser);
			menu.setUpdateDate(now);
			menu.setDeleteFlag(1);
			menu.setDeleteDate(now);

			tMbMenuMapper.updateByPrimaryKeySelective(menu);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("MenuServiceImpl,deleteMenu", e);
			return false;
		}
		log.info("MenuServiceImpl,deleteMenu:end");
		return true;
	}

	/**
	 * 寻找子菜单并添加上
	 *
	 * @param menu
	 */
	private void findSubMenuAndAdd(Map<String, Object> menu) {
		String id = String.valueOf(menu.get("id"));
		List<Map<String, Object>> subMenuList = menuMapper.getSubMenuListByParentId(id);
		if (subMenuList != null && subMenuList.size() > 0) {
			//有子菜单
			menu.put("children", subMenuList);
			for (Map<String, Object> subMenu : subMenuList) {
				findSubMenuAndAdd(subMenu);
			}
		}
	}

}
