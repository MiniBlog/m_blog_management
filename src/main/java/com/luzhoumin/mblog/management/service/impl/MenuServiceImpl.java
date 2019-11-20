package com.luzhoumin.mblog.management.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.mapper.MenuMapper;
import com.luzhoumin.mblog.management.mapper.generate.MSysMenuMapper;
import com.luzhoumin.mblog.management.pojo.MSysMenu;
import com.luzhoumin.mblog.management.service.MenuService;
import com.luzhoumin.mblog.management.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Service
public class MenuServiceImpl implements MenuService {
	private static Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
	@Resource
	MenuMapper menuMapper;
	@Resource
	MSysMenuMapper mSysMenuMapper;

	@Override
	public List<Map<String, Object>> getMenuList() {
		logger.info("**************** MenuServiceImpl,getMenuList:start ****************");
		List<Map<String, Object>> rootMenuList = menuMapper.getRootMenuList();
		for (Map<String, Object> rootMenu : rootMenuList) {
			findSubMenuAndAdd(rootMenu);
		}
		logger.info("**************** MenuServiceImpl,getMenuList:end ****************");
		return rootMenuList;
	}

	@Override
	public Map<String, Map<String, Object>> getPlainMenuMap() {
		logger.info("**************** MenuServiceImpl,getPlainMenuMap:start ****************");
		Map<String, Map<String, Object>> plainMenuMap = new LinkedHashMap<>();
		List<Map<String, Object>> plainMenuList = menuMapper.getPlainMenuList();
		for (Map<String, Object> row : plainMenuList) {
			plainMenuMap.put(String.valueOf(row.get("_key")), row);
		}
		logger.info("**************** MenuServiceImpl,getPlainMenuMap:end ****************");
		return plainMenuMap;
	}

	@Override
	public boolean addMenu(MSysMenu menu) {
		logger.info("**************** MenuServiceImpl,addMenu:start ****************");
		try {
			String loginUser = StrUtil.toString(SessionUtil.getSessionLoginUserName());
			Date now = new Date();
			String uuid = IdUtil.randomUUID();

			menu.setUuid(uuid);
			menu.setCreateBy(loginUser);
			menu.setCreateDate(now);
			menu.setUpdateBy(loginUser);
			menu.setUpdateDate(now);

			mSysMenuMapper.insertSelective(menu);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("MenuServiceImpl,addMenu", e);
			return false;
		}
		logger.info("**************** MenuServiceImpl,addMenu:end ****************");
		return true;
	}

	@Override
	public boolean modifyMenu(MSysMenu menu) {
		logger.info("**************** MenuServiceImpl,addMenu:start ****************");
		try {
			String loginUser = StrUtil.toString(SessionUtil.getSessionLoginUserName());
			Date now = new Date();

			menu.setUpdateBy(loginUser);
			menu.setUpdateDate(now);

			mSysMenuMapper.updateByPrimaryKeySelective(menu);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("MenuServiceImpl,modifyMenu", e);
			return false;
		}
		logger.info("**************** MenuServiceImpl,addMenu:end ****************");
		return true;
	}

	@Override
	public MSysMenu getMenuInfoByUuid(String uuid) {
		return null;
	}

	@Override
	public boolean deleteMenu(String uuid) {
		logger.info("**************** MenuServiceImpl,addMenu:start ****************");
		try {
			String loginUser = StrUtil.toString(SessionUtil.getSessionLoginUserName());
			Date now = new Date();

			MSysMenu menu = new MSysMenu();
			menu.setUuid(uuid);
			menu.setUpdateBy(loginUser);
			menu.setUpdateDate(now);
			menu.setDeleteFlag(1);
			menu.setDeleteDate(now);

			mSysMenuMapper.updateByPrimaryKeySelective(menu);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("MenuServiceImpl,deleteMenu", e);
			return false;
		}
		logger.info("**************** MenuServiceImpl,addMenu:end ****************");
		return true;
	}

	/**
	 * 寻找子菜单并添加上
	 *
	 * @param menu
	 */
	private void findSubMenuAndAdd(Map<String, Object> menu) {
		String uuid = String.valueOf(menu.get("uuid"));
		List<Map<String, Object>> subMenuList = menuMapper.getSubMenuListByParentUuid(uuid);
		if (subMenuList != null && subMenuList.size() > 0) {
			//有子菜单
			menu.put("children", subMenuList);
			for (Map<String, Object> subMenu : subMenuList) {
				findSubMenuAndAdd(subMenu);
			}
		}
	}

}
