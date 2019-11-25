package com.luzhoumin.mblog.management.service.impl;

import cn.hutool.core.util.StrUtil;
import com.luzhoumin.mblog.management.mapper.UserMapper;
import com.luzhoumin.mblog.management.mapper.generate.TMbUserMapper;
import com.luzhoumin.mblog.management.pojo.TMbUser;
import com.luzhoumin.mblog.management.service.UserService;
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
public class UserServiceImpl implements UserService {
	@Resource
	UserMapper userMapper;
	@Resource
	TMbUserMapper tMbUserMapper;

	@Override
	public Map<String, Object> getUserInfo(String userName) {
		log.info("UserServiceImpl,getUserInfo:start");
		if (StrUtil.isEmpty(userName)) {
			return null;
		}
		Map<String, Object> userInfo = userMapper.getUserInfo(userName);
		log.info("UserServiceImpl,getUserInfo:end");
		return userInfo;
	}

	@Override
	public TMbUser getUserInfoById(int id) {
		log.info("UserServiceImpl,getUserInfoByUuid:start");
		TMbUser tMbUser = tMbUserMapper.selectByPrimaryKey(id);
		log.info("UserServiceImpl,getUserInfoByUuid:end");
		return tMbUser;
	}

	@Override
	public Map<String, Object> getUserList(Map<String, String> paramMap, int pageNum, int pageSize) {
		log.info("UserServiceImpl,getUserList:start");
		Map<String, Object> data = new HashMap<>();
		int userListCount = userMapper.getUserListCount(paramMap);
		List<Map<String, Object>> userList = new ArrayList<>();
		if (userListCount > 0) {
			PageHelperUtil.addPaging(pageNum, pageSize);
			userList = userMapper.getUserList(paramMap);
		}
		data.put("list", userList);
		data.put("count", userListCount);
		log.info("UserServiceImpl,getUserList:end");
		return data;
	}

	@Override
	public boolean addUser(TMbUser user) {
		log.info("UserServiceImpl,addUser:start");
		try {
			String loginUser = StrUtil.toString(SessionUtil.getSessionLoginUserName());
			Date now = new Date();

			user.setCreateBy(loginUser);
			user.setCreateDate(now);
			user.setUpdateBy(loginUser);
			user.setUpdateDate(now);

			tMbUserMapper.insertSelective(user);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("UserServiceImpl,addUser", e);
			return false;
		}
		log.info("UserServiceImpl,addUser:end");
		return true;
	}

	@Override
	public boolean modifyUser(TMbUser user) {
		log.info("UserServiceImpl,modifyUser:start");
		try {
			user.setPass(null);
			tMbUserMapper.updateByPrimaryKeySelective(user);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("UserServiceImpl,modifyUser", e);
			return false;
		}
		log.info("UserServiceImpl,modifyUser:end");
		return true;
	}

	@Override
	public boolean deleteUser(TMbUser user) {
		log.info("UserServiceImpl,deleteUser:start");
		try {
			String loginUser = StrUtil.toString(SessionUtil.getSessionLoginUserName());
			Date now = new Date();
			user.setUpdateBy(loginUser);
			user.setUpdateDate(now);
			user.setDeleteFlag(1);
			user.setDeleteDate(now);
			tMbUserMapper.updateByPrimaryKeySelective(user);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("UserServiceImpl,deleteUser", e);
			return false;
		}
		log.info("UserServiceImpl,deleteUser:end");
		return true;
	}
}
