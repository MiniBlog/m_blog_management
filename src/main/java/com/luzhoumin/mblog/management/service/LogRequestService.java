package com.luzhoumin.mblog.management.service;

import java.util.Map;

/**
 * Created on October 10, 2019
 * Description:
 *
 * @author <a href="mailto:zmlu1996@gmail.com">Jacob Lu</a>
 * @since 1.8
 */
public interface LogRequestService {
	Map<String, Object> getRequestLogList(Map<String, String> paramMap, int pageNum, int pageSize);

}
