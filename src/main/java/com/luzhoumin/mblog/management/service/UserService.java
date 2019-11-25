package com.luzhoumin.mblog.management.service;

import com.luzhoumin.mblog.management.pojo.TMbUser;

import java.util.Map;

/**
 * Created on 九月 19, 2019
 * Description:
 *
 * @author <a href="mailto:zmlu1996@gmail.com">Jacob Lu</a>
 * @since 1.8
 */
public interface UserService {
	Map<String, Object> getUserInfo(String userName);

	TMbUser getUserInfoById(int id);

	Map<String, Object> getUserList(Map<String, String> paramMap, int pageNum, int pageSize);

	boolean addUser(TMbUser user);

	boolean modifyUser(TMbUser user);

	boolean deleteUser(TMbUser user);
}
