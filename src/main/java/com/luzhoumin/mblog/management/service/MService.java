package com.luzhoumin.mblog.management.service;

import java.util.List;
import java.util.Map;

/**
 * Created on October 11, 2019
 * Description:
 *
 * @author <a href="mailto:zmlu1996@gmail.com">Jacob Lu</a>
 * @since 1.8
 */
public interface MService {
	List<Map<String, Object>> getTableColumns(Map<String, String> paramMap);

	Map<String, Object> getList(Map<String, String> paramMap, int pageNum, int pageSize);
}
