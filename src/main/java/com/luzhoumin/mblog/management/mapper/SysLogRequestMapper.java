package com.luzhoumin.mblog.management.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created on October 10, 2019
 * Description:
 *
 * @author <a href="mailto:zmlu1996@gmail.com">Jacob Lu</a>
 * @since 1.8
 */
public interface SysLogRequestMapper {
	List<Map<String, Object>> getLogRequestList(Map<String, String> paramMap);

	int getLogRequestListCount(Map<String, String> paramMap);
}
