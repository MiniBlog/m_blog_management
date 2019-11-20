package com.luzhoumin.mblog.management.service.impl;

import com.github.pagehelper.util.StringUtil;
import com.luzhoumin.mblog.management.mapper.SysBlobMapper;
import com.luzhoumin.mblog.management.mapper.generate.MSysBlobMapper;
import com.luzhoumin.mblog.management.pojo.MSysBlob;
import com.luzhoumin.mblog.management.service.SysBlobService;
import com.luzhoumin.mblog.management.service.SysSequenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class SysBlobServiceImpl implements SysBlobService {
	private static Logger logger = LoggerFactory.getLogger(SysBlobServiceImpl.class);
	@Resource
	private SysBlobMapper sysBlobMapper;
	@Resource
	private MSysBlobMapper mSysBlobMapper;
	@Resource
	private SysSequenceService sysSequenceService;

	/**
	 * 获取附件信息
	 */
	@Override
	public Map<String, Object> getBlobInfo(String blobId) {
		logger.info("**********getBlobInfo 开始**********");

		if (StringUtil.isEmpty(blobId)) {
			logger.info("**********INCOMPLETE_PARAMETERS**********");
			logger.info("**********getBlobInfo 结束**********");
			return null;
		}

		//获取附件信息
		Map<String, Object> blobInfo = null;
		List<Map<String, Object>> blobList = sysBlobMapper.getBlobInfo(blobId);
		if (blobList != null && blobList.size() > 0) {
			blobInfo = blobList.get(0);
		}

		logger.info("**********getBlobInfo 结束**********");
		return blobInfo;
	}

	/**
	 * 保存附件信息
	 */
	@Override
	public String saveBlobData(Map<String, String> mapParams) {

		logger.info("**********saveBlobData 开始**********");
		String blobName = mapParams.get("blobName");
		String blobOriginalName = mapParams.get("blobOriginalName");
		String blobAddress = mapParams.get("blobAddress");

		if (StringUtil.isEmpty(blobName) || StringUtil.isEmpty(blobOriginalName) || StringUtil.isEmpty(blobAddress)) {
			logger.info("**********INCOMPLETE_PARAMETERS**********");
			logger.info("**********saveBlobData 结束**********");
			return "";
		}

		Date nowDate = new Date();
		//生成附件ID
		String blobId = sysSequenceService.getSequence("BLOB_ID");
		String userId = mapParams.get("userId");

		MSysBlob tEuBlob = new MSysBlob();
		//附件id
		tEuBlob.setBlob(blobId);
		//附件名称
		tEuBlob.setName(blobName);
		//附件原始名称
		tEuBlob.setOriginalName(blobOriginalName);
		//附件地址
		tEuBlob.setAddress(blobAddress);
		tEuBlob.setCreateBy(userId);
		tEuBlob.setCreateDate(nowDate);
		tEuBlob.setUpdateBy(userId);
		tEuBlob.setUpdateDate(nowDate);

		int ret = mSysBlobMapper.insertSelective(tEuBlob);
		if (ret <= 0) {
			return "";
		}

		logger.info("**********saveBlobData 结束**********");
		return blobId;
	}
}
