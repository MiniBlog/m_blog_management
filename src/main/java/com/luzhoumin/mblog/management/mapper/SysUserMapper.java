package com.luzhoumin.mblog.management.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created on 九月 19, 2019
 * Description:
 *
 * @author <a href="mailto:zmlu1996@gmail.com">Jacob Lu</a>
 * @since 1.8
 */
public interface SysUserMapper {
	Map<String, Object> getUserInfo(String userName);

	List<Map<String, Object>> getUserList(Map<String, String> paramMap);

	int getUserListCount(Map<String, String> paramMap);
}
