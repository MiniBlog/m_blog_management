package com.luzhoumin.mblog.management.mapper;

import java.util.List;
import java.util.Map;

public interface SysBlobMapper {
	/**
	 * 获取附件信息
	 */
	List<Map<String, Object>> getBlobInfo(String blobId);
}
