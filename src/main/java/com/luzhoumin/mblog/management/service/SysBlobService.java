package com.echemi.web.service.business;

import java.util.Map;

/**
 * BlobService
 */
public interface BlobService {

	/**
	 * 获取附件信息
	 * @param blobId
	 * @return
	 */
	public Map<String, Object> getBlobInfo(String blobId);

	/**
	 * 保存附件信息
	 * @param mapParams
	 * @return
	 */
	public String saveBlobData(Map<String, String> mapParams);

}
