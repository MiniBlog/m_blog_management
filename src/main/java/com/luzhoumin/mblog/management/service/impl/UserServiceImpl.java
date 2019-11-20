package com.luzhoumin.mblog.management.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.mapper.UserMapper;
import com.luzhoumin.mblog.management.mapper.generate.MSysUserMapper;
import com.luzhoumin.mblog.management.pojo.MSysUser;
import com.luzhoumin.mblog.management.service.UserService;
import com.luzhoumin.mblog.management.util.PageHelperUtil;
import com.luzhoumin.mblog.management.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Service
public class UserServiceImpl implements UserService {
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Resource
	UserMapper userMapper;
	@Resource
	MSysUserMapper mSysUserMapper;

	@Override
	public Map<String, Object> getUserInfo(String userName) {
		logger.info("**************** UserServiceImpl,getUserInfo:start ****************");
		if (StrUtil.isEmpty(userName)) {
			return null;
		}
		Map<String, Object> userInfo = userMapper.getUserInfo(userName);
		logger.info("**************** UserServiceImpl,getUserInfo:end ****************");
		return userInfo;
	}

	@Override
	public MSysUser getUserInfoByUuid(String uuid) {
		logger.info("**************** UserServiceImpl,getUserInfoByUuid:start ****************");
		if (StrUtil.isEmpty(uuid)) {
			return null;
		}
		MSysUser mSysUser = mSysUserMapper.selectByPrimaryKey(uuid);
		logger.info("**************** UserServiceImpl,getUserInfoByUuid:end ****************");
		return mSysUser;
	}

	@Override
	public Map<String, Object> getUserList(Map<String, String> paramMap, int pageNum, int pageSize) {
		logger.info("**************** UserServiceImpl,getUserList:start ****************");
		Map<String, Object> data = new HashMap<>();
		int userListCount = userMapper.getUserListCount(paramMap);
		List<Map<String, Object>> userList = new ArrayList<>();
		if (userListCount > 0) {
			PageHelperUtil.addPaging(pageNum, pageSize);
			userList = userMapper.getUserList(paramMap);
		}
		data.put("list", userList);
		data.put("count", userListCount);
		logger.info("**************** UserServiceImpl,getUserList:end ****************");
		return data;
	}

	@Override
	public boolean addUser(MSysUser user) {
		logger.info("**************** UserServiceImpl,addUser:start ****************");
		try {
			String loginUser = StrUtil.toString(SessionUtil.getSessionLoginUserName());
			Date now = new Date();
			String uuid = IdUtil.randomUUID();

			user.setUuid(uuid);
			user.setCreateBy(loginUser);
			user.setCreateDate(now);
			user.setUpdateBy(loginUser);
			user.setUpdateDate(now);

			mSysUserMapper.insertSelective(user);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("UserServiceImpl,addUser", e);
			return false;
		}
		logger.info("**************** UserServiceImpl,addUser:end ****************");
		return true;
	}

	@Override
	public boolean modifyUser(MSysUser user) {
		logger.info("**************** UserServiceImpl,modifyUser:start ****************");
		try {
			mSysUserMapper.updateByPrimaryKeySelective(user);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("UserServiceImpl,modifyUser", e);
			return false;
		}
		logger.info("**************** UserServiceImpl,modifyUser:end ****************");
		return true;
	}

	@Override
	public boolean deleteUser(MSysUser user) {
		logger.info("**************** UserServiceImpl,deleteUser:start ****************");
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
			logger.error("UserServiceImpl,deleteUser", e);
			return false;
		}
		logger.info("**************** UserServiceImpl,deleteUser:end ****************");
		return true;
	}
}
