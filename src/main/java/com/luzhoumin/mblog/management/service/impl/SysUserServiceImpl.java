package com.luzhoumin.mblog.management.service.impl;

import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.mapper.SysUserMapper;
import com.luzhoumin.mblog.management.mapper.generate.MSysUserMapper;
import com.luzhoumin.mblog.management.pojo.MSysUser;
import com.luzhoumin.mblog.management.service.SysUserService;
import com.luzhoumin.mblog.management.util.PageHelperUtil;
import com.luzhoumin.mblog.management.util.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created on 九月 19, 2019
 * Description:
 *
 * @author <a href="mailto:zmlu1996@gmail.com">Jacob Lu</a>
 * @since 1.8
 */
@Slf4j
@Service
public class SysUserServiceImpl implements SysUserService {
	@Resource
	SysUserMapper sysUserMapper;
	@Resource
	MSysUserMapper mSysUserMapper;

	@Override
	public Map<String, Object> getUserInfo(String userName) {
		log.info("UserServiceImpl,getUserInfo:start");
		if (StrUtil.isEmpty(userName)) {
			return null;
		}
		Map<String, Object> userInfo = sysUserMapper.getUserInfo(userName);
		log.info("UserServiceImpl,getUserInfo:end");
		return userInfo;
	}

	@Override
	public MSysUser getUserInfoById(int id) {
		log.info("UserServiceImpl,getUserInfoByUuid:start");
		MSysUser mSysUser = mSysUserMapper.selectByPrimaryKey(id);
		log.info("UserServiceImpl,getUserInfoByUuid:end");
		return mSysUser;
	}

	@Override
	public Map<String, Object> getUserList(Map<String, String> paramMap, int pageNum, int pageSize) {
		log.info("UserServiceImpl,getUserList:start");
		Map<String, Object> data = new HashMap<>();
		int userListCount = sysUserMapper.getUserListCount(paramMap);
		List<Map<String, Object>> userList = new ArrayList<>();
		if (userListCount > 0) {
			PageHelperUtil.addPaging(pageNum, pageSize);
			userList = sysUserMapper.getUserList(paramMap);
		}
		data.put("list", userList);
		data.put("count", userListCount);
		log.info("UserServiceImpl,getUserList:end");
		return data;
	}

	@Override
	public boolean addUser(MSysUser user) {
		log.info("UserServiceImpl,addUser:start");
		try {
			String loginUser = StrUtil.toString(SessionUtil.getSessionLoginUserName());
			Date now = new Date();

			user.setCreateBy(loginUser);
			user.setCreateDate(now);
			user.setUpdateBy(loginUser);
			user.setUpdateDate(now);

			mSysUserMapper.insertSelective(user);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("UserServiceImpl,addUser", e);
			return false;
		}
		log.info("UserServiceImpl,addUser:end");
		return true;
	}

	@Override
	public boolean modifyUser(MSysUser user) {
		log.info("UserServiceImpl,modifyUser:start");
		try {
			mSysUserMapper.updateByPrimaryKeySelective(user);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("UserServiceImpl,modifyUser", e);
			return false;
		}
		log.info("UserServiceImpl,modifyUser:end");
		return true;
	}

	@Override
	public boolean deleteUser(MSysUser user) {
		log.info("UserServiceImpl,deleteUser:start");
		try {
			String loginUser = StrUtil.toString(SessionUtil.getSessionLoginUserName());
			Date now = new Date();
			user.setUpdateBy(loginUser);
			user.setUpdateDate(now);
			user.setDeleteFlag(1);
			user.setDeleteDate(now);
			mSysUserMapper.updateByPrimaryKeySelective(user);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("UserServiceImpl,deleteUser", e);
			return false;
		}
		log.info("UserServiceImpl,deleteUser:end");
		return true;
	}
}
